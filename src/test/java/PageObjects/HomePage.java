package PageObjects;

public class HomePage extends BasePage{

    public void getHomePage() {
        response = sendGetRequest("");
    }

    public String getLoggedInUsername (){
        return getGpathFromXmlBody("**.find {it.@class=='account'}.span");
    }
}
