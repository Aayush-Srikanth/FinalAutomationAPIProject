package Tests;

import PageObjects.HomePage;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateAccTest {

    HomePage homePage = new HomePage();

    @Test
    public void Test1() {
        Response response = RestAssured.get("http://3.11.77.136/index.php");
        Assertions.assertEquals(200, response.getStatusCode());

    }

    @Test
    public void Test2(){
        homePage.getHomePage();
        Assertions.assertEquals(200, homePage.getStatusCode());
    }

}
