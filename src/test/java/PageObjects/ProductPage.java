package PageObjects;

import java.util.HashMap;
import java.util.Map;

public class ProductPage extends BasePage {

    public String retrieveToken(int productId) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id_product", productId);
        queryParams.put("id_product_attribute", "1");
        queryParams.put("rewrite", "faded-short-sleeves-tshirt");
        queryParams.put("controller", "product");
        sendGetRequest("", queryParams);
        return getGpathFromXmlBody("**.find {it.@name == 'token'}.@value");
    }

    public void selectProduct(int productId, int productQuantity) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("token", retrieveToken(productId));
        formData.put("id_product", productId);
        formData.put("id_customization", "0");
        formData.put("group[1]", "1");
        formData.put("group[3]", "13");
        formData.put("qty", productQuantity);
        formData.put("add", "1");
        formData.put("action", "update");


        response = httpRequest.filter(cookieFilter)
                .queryParam("controller", "cart")
                .formParams(formData)
                .post("/");
    }
}
