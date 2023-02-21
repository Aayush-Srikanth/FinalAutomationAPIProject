package Tests;

import PageObjects.CreateAccountPage;
import PageObjects.HomePage;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateAccTest {

    HomePage homePage = new HomePage();
    CreateAccountPage createAccountPage = new CreateAccountPage();
    @Test
    public void Test2(){
        homePage.getHomePage();
        Assertions.assertEquals(200, homePage.getStatusCode());
    }
    @Test
    public void createNewAcc(){
        createAccountPage.createAcc();
    }
}
