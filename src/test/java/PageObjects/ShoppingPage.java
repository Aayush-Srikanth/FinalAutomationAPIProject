package PageObjects;

import java.util.HashMap;
import java.util.Map;

public class ShoppingPage extends BasePage {

    public void selectProduct(int productId, int productQuantity) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("token", "8934763adde45dbfa9445e979a178bff");
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
