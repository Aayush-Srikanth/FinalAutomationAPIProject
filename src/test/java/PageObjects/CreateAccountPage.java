package PageObjects;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import java.util.HashMap;
import java.util.Map;


public class CreateAccountPage extends BasePage {

    private String generateEmail = RandomStringUtils.randomAlphabetic(7);

    public void createAcc() {
        //Base URI defined in Base Page
        //Passing the resource details

        Map<String, Object> formData = new HashMap<>();
        formData.put("id_gender", "1");
        formData.put("firstname", "Benjamin");
        formData.put("lastname", "Button");
        formData.put("email", generateEmail + "@test.com");
        formData.put("password", "wordpass");
        formData.put("birthday", "12/06/1992");
        formData.put("submitCreate", 1);

        response = httpRequest.filter(cookieFilter)
                .queryParam("controller", "authentication")
                .queryParam("create_account", "1")
                .formParams(formData)
                .post();

        assertStatusCode(302);
        getGpathFromXmlBody("**.find {it.@class=='account'}.span");
        Assertions.assertEquals("Benjamin Button", pageElement);

    }
}
