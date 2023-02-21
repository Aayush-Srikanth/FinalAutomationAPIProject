package Tests;

import PageObjects.CreateAccountPage;
import PageObjects.HomePage;
import org.junit.jupiter.api.Test;

public class CreateAccTest {

    HomePage homePage = new HomePage();
    CreateAccountPage createAccountPage = new CreateAccountPage();
    @Test
    public void Test2(){
        homePage.getHomePage();
        homePage.assertStatusCode(200);
    }
    @Test
    public void createNewAcc(){
        createAccountPage.createAcc();
        createAccountPage.assertStatusCode(200);
    }
}
