package PageObjects;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

        Assertions.assertEquals(302, response.getStatusCode());
        XmlPath xmlPath = new XmlPath(XmlPath.CompatibilityMode.HTML, getResponseBody());
        String username = xmlPath.get("**.find {it.@class=='account'}.span").toString();
        Assertions.assertEquals("Benjamin Button", username);

    }
}
