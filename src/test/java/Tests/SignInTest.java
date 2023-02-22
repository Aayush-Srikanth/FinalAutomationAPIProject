package Tests;


import PageObjects.AccountPage;
import PageObjects.HomePage;
import PageObjects.SignInPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SignInTest {
    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage() ;
    AccountPage accountPage = new AccountPage();

    @Test
    public void signInWithManualDetails(){
        signInPage.signInValidManualAccDetails();
        signInPage.assertStatusCode(302);
        homePage.getHomePage();
        Assertions.assertEquals("ben button", homePage.getLoggedInUsername());
        accountPage.getAccountPage();
        Assertions.assertEquals("Your account",accountPage.getAccountHeader().trim());
    }
}
