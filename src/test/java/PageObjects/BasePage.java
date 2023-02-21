package PageObjects;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

abstract class BasePage {

    Response response;

    public String baseURL="http://3.11.77.136/index.php";
 
    public Response sendGetRequest(String url) {
        return RestAssured.given()
                .when()
                .get(url)
                .then().contentType(ContentType.HTML)
                .extract()
                .response();

    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getBodyResponse(){
        return response.getBody().asString();
    }

}
