package Tests;


import PageObjects.AccountPage;
import PageObjects.HomePage;
import PageObjects.SignInPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SignInTest {
    HomePage homePage;
    SignInPage signInPage;
    AccountPage accountPage;
    public SignInTest() {
        homePage = new HomePage();
        signInPage = new SignInPage() ;
        accountPage = new AccountPage();
    }

    @Test
    public void signInWithManualDetails(){
        signInPage.signInValidManualAccDetails();
        signInPage.assertStatusCode(302);
        homePage.getHomePage();
        Assertions.assertEquals("ben button", homePage.getLoggedInUsername());
        accountPage.getAccountPage();
        Assertions.assertEquals("Your account",accountPage.getPageHeader().trim());
    }
    @Test
    public void signInWithNewAccountDetails(){
        signInPage.signInWithNewAccDetails();
        signInPage.assertStatusCode(302);
        homePage.getHomePage();
        Assertions.assertEquals("Benjamin Button", homePage.getLoggedInUsername());
        accountPage.getAccountPage();
        Assertions.assertEquals("Your account",accountPage.getPageHeader().trim());
    }


}
