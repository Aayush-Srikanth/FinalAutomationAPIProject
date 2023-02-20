package PageObjects;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

abstract class BasePage {

    public int getStatus(String requestParameter) {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, requestParameter);
        return response.getStatusCode();
    }
    public String getResponse(String requestParameter) {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, requestParameter);
        return response.prettyPrint();
    }

}
