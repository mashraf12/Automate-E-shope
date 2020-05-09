package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderShippingPage extends OrderSummaryPage{
    
    @FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
    private WebElement proceedButton;

    @FindBy (xpath = "//*[@id='cgv']")
    private WebElement agreeMark;

    public OrderShippingPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void markAgree(){
        agreeMark.click();
    }

    public void proceedClick(){
        proceedButton.click();
    }

    public void agreeAndProceed(){
        this.markAgree();
        this.proceedClick();
    }
}