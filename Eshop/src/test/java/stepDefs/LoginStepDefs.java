package stepDefs;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.*;
import java.util.List;
import java.util.Map;

public class LoginStepDefs {

    private WebDriver driver;
    final String BASE_URL = "http://automationpractice.com";

    HomePage objHome;
    LoginPage objLogin;

    public LoginStepDefs(TestContext testContext){
        this.driver = testContext.getDriver();
        objHome = new HomePage(driver);
        objLogin = new LoginPage(driver);
    }

    @Given("^User navigates to the page$")
    public void userNavigatesToThePage() {
        driver.navigate().to(BASE_URL);
    }

    @And("^User clicks login link$")
    public void userClicksLoginLink() {
        objHome.loginLinkClick();
    }

    @And("^User logins to the e-shop using credentials$")
    public void userLoginsToTheEShopUsingCredentials(DataTable dt) {
        List<Map<String, String>> myMap = dt.asMaps(String.class, String.class);
        for (Map<String, String> m : myMap){
            String userName = m.get("username");
            String pass = m.get("password");
            objLogin.loginExecute(userName, pass);
        }

    }
}
