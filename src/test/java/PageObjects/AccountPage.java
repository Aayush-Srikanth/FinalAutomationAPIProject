package PageObjects;

public class AccountPage extends BasePage{
    public void getAccountPage() {
        response = sendGetRequest("?controller=my-account");
    }
    public String getAccountHeader (){
        return getGpathFromXmlBody("**.find {it.@class=='page-header'}.h1");
    }
}
