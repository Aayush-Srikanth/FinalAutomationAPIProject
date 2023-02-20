package PageObjects;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

abstract class BasePage {

    public String getStatus(String requestParameter) {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, requestParameter);
        return "Status received => " + response.getStatusLine();
    }
    public String getResponse(String requestParameter) {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, requestParameter);
        return "Response=>" + response.prettyPrint();
    }

}
