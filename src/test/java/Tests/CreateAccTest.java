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
    public void createAccountTest() {
        createAccountPage.createAccount();
        Assertions.assertEquals(302, createAccountPage.getStatusCode());
        homePage.getHomePage();
        Assertions.assertEquals("Benjamin Button", homePage.getLoggedInUsername());
    }

    @Test
    public void createAccountAsRegisteredUserTest() {
        createAccountPage.createAccountAsRegisteredUser();
        Assertions.assertEquals("The email \"Bbutton@test1.com\" is already used, please choose another one or sign in",
                createAccountPage.getEmailAlreadyRegisteredAlert());


    }
}
