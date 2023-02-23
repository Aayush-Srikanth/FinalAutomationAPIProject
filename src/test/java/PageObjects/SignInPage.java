package PageObjects;


import java.util.HashMap;
import java.util.Map;

public class SignInPage extends BasePage {
    public void signInValidManualAccDetails() {
        Map<String,Object> queryParams = new HashMap<>();
        queryParams.put("controller", "authentication");
        queryParams.put("back", "my-account");

        Map<String,Object> formData = new HashMap<>();
        formData.put("back", "my-account");
        formData.put("email","Bbutton@test1.com");
        formData.put("password","wordpass");
        formData.put("submitLogin",1);

        sendPostRequest("",formData,queryParams);
    }

    public void signInWithNewAccDetails(){
        Map<String,Object> queryParams = new HashMap<>();
        queryParams.put("controller", "authentication");
        queryParams.put("back", "my-account");

        Map<String,Object> formData = new HashMap<>();
        formData.put("back", "my-account");
        formData.put("email","fjDRkRT@test.com");
//        formData.put("email",createAccountPage.generateEmail +"@test.com");
        formData.put("password","wordpass");
        formData.put("submitLogin",1);

        sendPostRequest("",formData,queryParams);
    }
}
