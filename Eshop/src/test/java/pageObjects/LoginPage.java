package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy (xpath = "//*[@id='email']")
    private WebElement usernameInput;

    @FindBy(xpath = "//*[@id='passwd']")
    private WebElement passwordInput;

    @FindBy (xpath = "//*[@id=\"SubmitLogin\"]/span")
    private WebElement loginSubmit;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public void typeUsername(String strUsername){
        usernameInput.clear();
        usernameInput.sendKeys(strUsername);
    }

    public void typePassword(String strPassword){
        passwordInput.clear();
        passwordInput.sendKeys(strPassword);
    }

    public void submitClick(){
        loginSubmit.click();
    }

    public void loginExecute(String strUsername, String strPassword){
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        typeUsername(strUsername);
        typePassword(strPassword);
        submitClick();
    }





}
