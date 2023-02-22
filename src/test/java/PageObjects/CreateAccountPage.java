package PageObjects;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;

public class CreateAccountPage extends BasePage {

    private String generateEmail = RandomStringUtils.randomAlphabetic(7);

    public void createNewAccount() {

        Map<String, Object> formData = new HashMap<>();
        formData.put("id_gender", "1");
        formData.put("firstname", "Benjamin");
        formData.put("lastname", "Button");
        formData.put("email", generateEmail + "@test.com");
        formData.put("password", "wordpass");
        formData.put("birthday", "12/06/1992");
        formData.put("submitCreate", 1);

        Map <String, Object> queryParams = new HashMap<>();
        queryParams.put("controller", "authentication");
        queryParams.put("create_account", "1");

        sendPostRequest("", formData, queryParams );

        /*response = httpRequest
                .filter(cookieFilter)
                .queryParam("controller", "authentication")
                .queryParam("create_account", "1")
                .formParams(formData)
                .post();*/

        /**
         * 1) Make a reusable post method that takes in the formdata as a parameter
         * */

    }
}
