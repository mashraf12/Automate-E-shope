package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderSummaryPage{
    protected WebDriver driver;
    protected WebDriverWait wait;
    
    @FindBy(xpath = "//*[@id='center_column']/p[2]/a[1]")
    private WebElement proceedButton;

    public OrderSummaryPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public void proceedClick(){
        this.proceedButton.click();
    }
}
