package PageObjects;

public class AccountPage extends BasePage{
    public void getAccountPage() {
        response = sendGetRequest("?controller=my-account");
    }


}
