package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPaymentPage extends OrderSummaryPage{
    
    @FindBy(xpath = "//*[@id='HOOK_PAYMENT']/div[2]/div/p/a")
    private WebElement payChequeButton;

    @FindBy (xpath = "//form/p/button") //USE AFTER CLICKING PAYMENT METHOD ONLY
    private WebElement confirmButton;

    @FindBy (xpath = "//div/div[3]/div/p[1]") ///html/body/div/div[2]/div/div[3]/div/p[1]
    private WebElement totalPriceText;

    @FindBy (xpath = "//*[@id='center_column']/p[2]/a")
    private WebElement backToOrdersLink;

    public OrderPaymentPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void payChequeClick(){
        payChequeButton.click();
    }

    public void confirmClick(){
        confirmButton.click();
    }

    public void payCheque(){
        this.payChequeClick();
        this.confirmClick();
    }

    //USE AFTER PAY
    public String getTotalPrice(){
        return totalPriceText.getText();
    }

    public void goBackToOrders(){
        backToOrdersLink.click();
    }
}