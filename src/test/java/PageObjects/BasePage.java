package PageObjects;

import io.restassured.RestAssured;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

abstract class BasePage {

    Response response;
    String pageElement;
    RequestSpecification httpRequest;
    private static final String BASE_URL = "http://3.11.77.136/index.php";
    static CookieFilter cookieFilter = new CookieFilter();

    public BasePage() {
        RestAssured.baseURI = BASE_URL;
        httpRequest = RestAssured.given().filter(cookieFilter);
    }

    public void assertStatusCode(int statusCode) {
        Assertions.assertEquals(statusCode, getStatusCode());
    }

    public String getGpathFromXmlBody(String gPath) {
        XmlPath xmlPath = new XmlPath(XmlPath.CompatibilityMode.HTML, getResponseBody());
        return pageElement = xmlPath.get(gPath).toString();
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

    //public Response sendPostRequest()

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getResponseBody() {
        return response.getBody().asPrettyString();
    }

}
