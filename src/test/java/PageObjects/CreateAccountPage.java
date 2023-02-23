package PageObjects;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;

public class CreateAccountPage extends BasePage {

    private String generateEmail = RandomStringUtils.randomAlphabetic(7);

    public void createAccount() {
        Map<String, Object> formData = new HashMap<>();
        formData.put("id_gender", "1");
        formData.put("firstname", "Benjamin");
        formData.put("lastname", "Button");
        formData.put("email", generateEmail + "@test.com");
        formData.put("password", "wordpass");
        formData.put("birthday", "12/06/1992");
        formData.put("submitCreate", 1);

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("controller", "authentication");
        queryParams.put("create_account", "1");

        sendPostRequest("", formData, queryParams);
    }

    public void createAccountAsRegisteredUser() {
        Map<String, Object> formData = new HashMap<>();
        formData.put("id_gender", "1");
        formData.put("firstname", "Benjamin");
        formData.put("lastname", "Button");
        formData.put("email", "Bbutton@test1.com");
        formData.put("password", "wordpass");
        formData.put("birthday", "12/06/1992");
        formData.put("submitCreate", 1);

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("controller", "authentication");
        queryParams.put("create_account", "1");

        sendPostRequest("", formData, queryParams);
    }

    public String getEmailAlreadyRegisteredAlert() {
        return getGpathFromXmlBody("**.find {it.@class=='alert alert-danger'}");
    }
}
