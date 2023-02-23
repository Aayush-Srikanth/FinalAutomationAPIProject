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
    CreateAccountPage createAccountPage;

    public BaseTest() {
        accountPage = new AccountPage();
        cartPage = new CartPage();
        createAccountPage = new CreateAccountPage();
        homePage = new HomePage();
        productPage = new ProductPage();
        signInPage = new SignInPage();
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
