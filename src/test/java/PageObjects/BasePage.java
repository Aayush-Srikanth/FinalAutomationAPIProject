package PageObjects;

import io.restassured.RestAssured;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

abstract class BasePage {

    Response response;
    String pageElement;
    RequestSpecification httpRequest;
    private static final String BASE_URL = "http://3.11.77.136/index.php";

    public BasePage() {
        RestAssured.baseURI = BASE_URL;
        httpRequest = RestAssured.given();

    }
    public void assertStatusCode(int statusCode){
        Assertions.assertEquals(statusCode, response.getStatusCode());
    }
    public String getGpathFromXmlBody(String gPath){
        XmlPath xmlPath = new XmlPath(XmlPath.CompatibilityMode.HTML, getResponseBody());
        return pageElement = xmlPath.get(gPath).toString();
    }
//    "**.find {it.@class=='account'}.span"
    CookieFilter cookieFilter = new CookieFilter();

    public Response sendGetRequest(String url) {
        response = RestAssured.given()
                .filter(cookieFilter)
                .when()
                .get(url)
                .then().contentType(ContentType.HTML)
                .extract()
                .response();
        return response;

    }

    public void logResponseDetails() {
        System.out.println("Status Code = " + getStatusCode());
        System.out.println("Cookies = " + getCookies());
    }

    public Cookies getCookies() {
        return response.getDetailedCookies();
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getResponseBody() {
        sendGetRequest("");
        return response.getBody().asPrettyString();
    }


}
