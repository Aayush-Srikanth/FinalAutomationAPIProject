package PageObjects;

public class CartPage extends BasePage{

    public void getCartPage() {
        response = sendGetRequest("?controller=cart&action=show");
    }
    public String getProductLineInfo (){
        return getGpathFromXmlBody("**.find {it.@class=='product-line-info'}.a");
    }
}
