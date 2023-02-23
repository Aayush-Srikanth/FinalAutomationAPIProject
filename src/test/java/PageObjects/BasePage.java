package PageObjects;

import io.restassured.RestAssured;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.http.ContentType;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;


import java.util.Map;

abstract class BasePage {

    Response response;
    String pageElement;
    RequestSpecification httpRequest;
    private static final String BASE_URL = "http://3.11.77.136/index.php";
    public static CookieFilter cookieFilter;

    public BasePage() {
        RestAssured.baseURI = BASE_URL;
        cookieFilter = new CookieFilter();
        httpRequest = RestAssured.given().filter(cookieFilter);
    }

    public void assertStatusCode(int statusCode) {
        Assertions.assertEquals(statusCode, getStatusCode());
    }

    public String getGpathFromXmlBody(String gPath) {
        XmlPath xmlPath = new XmlPath(XmlPath.CompatibilityMode.HTML, getResponseBody());
        pageElement = xmlPath.get(gPath).toString();
        return pageElement;
    }

    //    "**.find {it.@class=='account'}.span"

    public Response sendGetRequest(String endpoint) {
        response = httpRequest
                .filter(cookieFilter)
                .when()
                .get(endpoint)
                .then().contentType(ContentType.HTML)
                .extract()
                .response();
        return response;
    }

    public Response sendGetRequest(String path,
                                   Map<String, Object> queryParams) {
        response = httpRequest
                .filter(cookieFilter)
                .queryParams(queryParams)
                .get(path);
        return response;
    }

    public Response sendPostRequest(String path, Map<String, Object> formParams,
                                    Map<String, Object> queryParams) {
        response = httpRequest
                .filter(cookieFilter)
                .queryParams(queryParams)
                .formParams(formParams)
                .post(path);
        return response;
    }
    public void clearCookies(){
        ((RequestSpecificationImpl) httpRequest).removeCookies();
    }
    public void userLogout(){
        response = sendGetRequest("?mylogout=");
    }
    public String getPageHeader(){
        return getGpathFromXmlBody("**.find {it.@class=='page-header'}.h1");
    }
    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getResponseBody() {
        return response.getBody().asPrettyString();
    }

}
