package Tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddToCartTest extends BaseTest{
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
