package Tests;

import PageObjects.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    HomePage homePage;
    SignInPage signInPage;
    CartPage cartPage;
    ProductPage productPage;
    AccountPage accountPage;

    public BaseTest() {
        homePage = new HomePage();
        signInPage = new SignInPage();
        cartPage = new CartPage();
        productPage = new ProductPage();
        accountPage = new AccountPage();
    }

    @BeforeAll
    static void beforeAll() {

    }

    @BeforeEach
    void beforeEach() {
    homePage.clearCookies();

    }

    @AfterEach
    void afterEach() {

    }

    @AfterAll
   static void afterAll() {

    }
}
