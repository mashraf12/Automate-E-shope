package stepDefs;
import org.testng.Assert;
import pageObjects.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class ShopTestStepDefs {

    private WebDriver driver;

    HomePage objHome;
    WomenCategoryPage objWomenCtgr;
    ProductInfoPage objProductInfo;
    OrderSummaryPage objOrderSummary;
    OrderAddressPage objOrderAddress;
    OrderShippingPage objOrderShipping;
    OrderPaymentPage objOrderPayment;
    OrderHistoryPage objOrderHistory;
    String currentOrderPrice = "";

    public ShopTestStepDefs(TestContext testContext){
        this.driver = testContext.getDriver();
        objHome = new HomePage(driver);
        objWomenCtgr = new WomenCategoryPage(driver);
        objProductInfo = new ProductInfoPage(driver);
        objOrderSummary = new OrderSummaryPage(driver);
        objOrderAddress = new OrderAddressPage(driver);
        objOrderShipping = new OrderShippingPage(driver);
        objOrderPayment = new OrderPaymentPage(driver);
        objOrderHistory = new OrderHistoryPage(driver);
    }

    @When("^User clicks women category button$")
    public void userClicksWomenCategoryButton() {
        objHome.womenCategoryClick();
    }

    @And("^User randomly chooses product and is redirected to Order Summary Page$")
    public void userRandomlyChoosesProduct() {
        currentOrderPrice = objWomenCtgr.checkoutItem();
    }

    @And("^User continues clicking proceed button and is redirected to Order Address Page$")
    public void userContinuesClickingProceedButtonAndIsRedirectedToOrderAddressPage() {
        objOrderSummary.proceedClick();
    }

    @And("^User clicks proceed and is redirected to Order Shipping Page$")
    public void userClicksProceedAndIsRedirectedToOrderShippingPage() {
        objOrderAddress.proceedClick();
    }

    @And("^User marks agreement, clicks proceed and redirects to Order Payment Page$")
    public void userMarksAgreementClicksProceedAndRedirectsToOrderPaymentPage() {
        objOrderShipping.agreeAndProceed();
    }

    @And("^User clicks on Pay By Cheque$")
    public void userClicksOnPayByCheque() {
        objOrderPayment.payCheque();
    }

    @Then("^User gets \"([^\"]*)\" order result message$")
    public void userGetsOrderResultMessage(String strResult){
        Assert.assertTrue(objOrderPayment.getTotalPrice().contains(strResult));
    }

    @When("^User clicks go back to orders$")
    public void userClicksGoBackToOrders() {
        objOrderPayment.goBackToOrders();
    }

    @Then("^User verifies his last order price is correct$")
    public void userVerifiesHisLastOrderPriceIsCorrect() {
        Assert.assertTrue(objOrderHistory.getLastOrderPrice().contains(currentOrderPrice));
    }
}
