package PageObjects;

import org.junit.jupiter.api.Assertions;

public class SignInPage extends BasePage {
    public void signInValidManualAccDetails() {
        response = httpRequest.filter(cookieFilter)
                .queryParam("controller", "authentication")
                .queryParam("back", "my-account")
                .formParam("back", "my-account")
                .formParam("email","Bbutton@test1.com")
                .formParam("password","wordpass" )
                .formParam("submitLogin",1 )
                .post("/");

        assertStatusCode(302);
        getGpathFromXmlBody("**.find {it.@class=='account'}.span");
        Assertions.assertEquals("ben button", pageElement);
    }
}
