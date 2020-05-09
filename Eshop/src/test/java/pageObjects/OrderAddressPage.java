package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderAddressPage extends OrderSummaryPage{
    
    @FindBy(xpath = "//*[@id='center_column']/form/p/button")
    private WebElement proceedButton;

    public OrderAddressPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void proceedClick(){
        this.proceedButton.click();
    }
}