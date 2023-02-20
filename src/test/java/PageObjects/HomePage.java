package PageObjects;

public class HomePage extends BasePage{


    public void getHomePage() {
        String url = "http://3.11.77.136/index.php";
        response = sendGetRequest(url);
    }
}
