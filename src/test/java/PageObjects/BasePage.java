package PageObjects;

import io.restassured.RestAssured;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

abstract class BasePage {

    Response response;

    RequestSpecification httpRequest;
    private static final String BASE_URL = "http://3.11.77.136/index.php";

    public BasePage() {
        RestAssured.baseURI = BASE_URL;
        httpRequest = RestAssured.given();

    }

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

    public Cookies getCookies() {
        return response.getDetailedCookies();
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getBodyResponse() {
        return response.getBody().asString();
    }

}
