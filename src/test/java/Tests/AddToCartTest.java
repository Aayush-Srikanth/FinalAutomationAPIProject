package Tests;

import PageObjects.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddToCartTest {

    HomePage homePage;
    SignInPage signInPage;
    CartPage cartPage;
    ProductPage productPage;

    public AddToCartTest() {
        homePage = new HomePage();
        signInPage = new SignInPage();
        cartPage = new CartPage();
        productPage = new ProductPage();
    }


    @Test
    public void addToCartUserSignedIn() {
        homePage.getHomePage();
        signInPage.signInValidManualAccDetails();
        productPage.selectProduct(1, 1);
        homePage.assertStatusCode(200);
        cartPage.getCartPage();
        Assertions.assertEquals("Faded Short Sleeves T-shirt", cartPage.getProductLineInfo());
        System.out.println(homePage.getResponseBody());
    }
}
