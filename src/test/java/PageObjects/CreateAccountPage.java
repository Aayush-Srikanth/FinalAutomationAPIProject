package PageObjects;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;

public class CreateAccountPage extends BasePage {
    private String generateEmail = RandomStringUtils.randomAlphabetic(7);

    public void createAcc() {
        //Defining the base URI
        RestAssured.baseURI = baseURL;
        RequestSpecification httpRequest = RestAssured.given();
        //Passing the resource details
        Response res = httpRequest.queryParam("controller", "authentication")
                .queryParam("create_account", "1").formParam("id_gender","1")
                .formParam("firstname","Benjamin")
                .formParam("lastname","Button")
                .formParam("email",generateEmail+"@test.com")
                .formParam("password","wordpass")
                .formParam("birthday","12/06/1992")
                .formParam("submitCreate",1).post("/");

        Assertions.assertEquals(302,res.getStatusCode());
        System.out.println("Status Code = "+res.getStatusCode());



//        //Retrieving the response body using getBody() method
//        ResponseBody body = res.body();
//        //Converting the response body to string object
//        String rbdy = body.asString();
//        //Creating object of XmlPath and passing the string response body as parameter
//        XmlPath xmlPath = new XmlPath(rbdy);
//        //Storing publisher name in a string variable
//        String title =xmlPath.getString("title");
//        System.out.println("The book title is - "+title);
    }
}
