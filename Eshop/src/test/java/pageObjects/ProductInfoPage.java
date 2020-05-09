package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductInfoPage extends WomenCategoryPage {

    @FindBy(xpath = "//*[@id='add_to_cart']/button")
    private WebElement addToCartBtn;

    @FindBy (xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")
    private WebElement preceedBtn;

    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[3]/span")
    private WebElement currentPrice;

    public ProductInfoPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addToCartClick(){
        addToCartBtn.click();
    }

    @Override
    public String getCurrentPrice(){
        return currentPrice.getText();
    }

    @Override
    public void proceedClick(){
        preceedBtn.click();
    }

    @Override
    public String checkoutItem(){
        this.addToCartClick();
        wait.until(ExpectedConditions.visibilityOf(preceedBtn));
        String currentOrderPrice = getCurrentPrice();
        this.proceedClick();
        return currentOrderPrice;
    }

}
