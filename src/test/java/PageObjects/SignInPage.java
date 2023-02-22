package PageObjects;



public class SignInPage extends BasePage {

    public void signInValidManualAccDetails() {
        response = httpRequest.filter(cookieFilter)
                .queryParam("controller", "authentication")
                .queryParam("back", "my-account")
                .formParam("back", "my-account")
                .formParam("email","Bbutton@test1.com")
                .formParam("password","wordpass" )
                .formParam("submitLogin",1 )
                .post();
    }
}
