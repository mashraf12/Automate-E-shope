package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//nav/div[1]/a")
    WebElement loginLink;

    @FindBy (xpath = "//nav/div[2]/a")
    private WebElement logoutLink;

    @FindBy (xpath = "//ul/li[1]/a")
    private WebElement womenCtgLink;

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public void loginLinkClick(){
       // wait.until(ExpectedConditions.visibilityOf(loginLink));
        this.loginLink.click();
    }

    public void logoutLinkClick(){
        logoutLink.click();
    }

    public void womenCategoryClick(){
        womenCtgLink.click();
    }
}
