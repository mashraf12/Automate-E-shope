package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage extends OrderSummaryPage{

    @FindBy(xpath = "//tr[1]/td[3]/span")
    private WebElement lastOrderPrice;

    public OrderHistoryPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getLastOrderPrice(){
        return lastOrderPrice.getText();
    }

}