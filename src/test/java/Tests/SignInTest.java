package Tests;


import PageObjects.SignInPage;
import org.junit.jupiter.api.Test;

public class SignInTest {
    SignInPage signInPage = new SignInPage() ;

    @Test
    public void signInWithManualDetails(){
        signInPage.signInValidManualAccDetails();
        signInPage.assertStatusCode(200);
    }
}
