package Tests;

import PageObjects.HomePage;
import PageObjects.ShoppingPage;
import PageObjects.SignInPage;
import org.junit.jupiter.api.Test;

public class AddToCartTest {
    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage();
    ShoppingPage shoppingPage = new ShoppingPage();

    @Test
    public void addToCartUserSignedIn() {
        homePage.getHomePage();
        signInPage.signInValidManualAccDetails();
        shoppingPage.selectProduct(6, 1);
        homePage.assertStatusCode(200);
        System.out.println(homePage.getResponseBody());
    }
}
