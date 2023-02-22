package Tests;

import PageObjects.CreateAccountPage;
import PageObjects.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateAccTest {

    HomePage homePage;
    CreateAccountPage createAccountPage;

    public CreateAccTest() {
        createAccountPage = new CreateAccountPage();
        homePage = new HomePage();
    }

    @Test
    public void getHomepageTest() {
        homePage.getHomePage();
        homePage.assertStatusCode(200);
    }

    @Test
    public void createNewAccountTest() {
        createAccountPage.createNewAccount();
        Assertions.assertEquals(302, createAccountPage.getStatusCode());
        homePage.getHomePage();
        Assertions.assertEquals("Benjamin Button", homePage.getLoggedInUsername());
    }
}
