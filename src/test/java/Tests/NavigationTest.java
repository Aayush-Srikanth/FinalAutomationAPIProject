package Tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NavigationTest extends BaseTest{
    @Test
    public void getHomepageTest() {
        homePage.getHomePage();
        homePage.assertStatusCode(200);
    }

    @Test
    public void accessMyAccountPageWithoutLoginIn(){
        homePage.userLogout();
        homePage.assertStatusCode(200);
        accountPage.getAccountPage();
        accountPage.assertStatusCode(200);//interesting result
        Assertions.assertEquals("Log in to your account",accountPage.getPageHeader().trim());
    }
}
