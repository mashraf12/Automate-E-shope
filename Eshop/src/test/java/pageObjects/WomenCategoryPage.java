package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class WomenCategoryPage{
    protected WebDriver driver;
    protected WebDriverWait wait;

    private By byItemsList = By.xpath("//*[@id='center_column']/ul/li");

    @FindBy(xpath = "//ul/li[1]/a")
    private WebElement womenCtgLink;

    @FindBy(xpath = "//*[@id='add_to_cart']/button")
    private WebElement addToCartBtn;

    @FindBy (xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")
    private WebElement preceedBtn;

    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[3]/span")
    private WebElement currentPrice;

    private Random rand;

    public WomenCategoryPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        rand = new Random();
        PageFactory.initElements(driver, this);
    }

    public WebElement getItemWebElement(int i){
        return driver.findElement(By.xpath("//*[@id='center_column']/ul/li["+i+"]/div"));
    }

    public WebElement getAddToCartLinkWebElement(int i){
        return driver.findElement(By.xpath("//*[@id='center_column']/ul/li["+i+"]/div/div[2]/div[2]/a[1]"));
    }

    public WebElement randomChoose(){
        List<WebElement> itemsList = driver.findElements(byItemsList);
        int i = rand.nextInt(itemsList.size() - 1) + 1;
        Actions action  = new Actions(driver);
        action.moveToElement(this.getItemWebElement(i));
        action.build().perform();
        return this.getAddToCartLinkWebElement(i);
    }

    public void addToCartClick(WebElement webElementAddToCart){
        webElementAddToCart.click();
    }

    public String getCurrentPrice(){
        return currentPrice.getText();
    }

    public void proceedClick(){
        preceedBtn.click();
    }

    public String checkoutItem(){
        this.addToCartClick(this.randomChoose());
        wait.until(ExpectedConditions.visibilityOf(preceedBtn));
        String currentOrderPrice = getCurrentPrice();
        this.proceedClick();
        return currentOrderPrice;
    }
}
