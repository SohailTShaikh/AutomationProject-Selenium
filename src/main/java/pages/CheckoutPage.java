package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CheckoutPage {

    private WebDriver driver;
    private WaitUtils wait;

    private By addressDetails =
            By.xpath("//h2[contains(normalize-space(.),'Address Details')]");

    private By reviewOrder =
            By.xpath("//h2[contains(normalize-space(.),'Review Your Order')]");

    private By comment =
            By.name("message");

    private By placeOrder =
            By.xpath("//a[contains(text(),'Place Order')]");

    private By cardName =
            By.name("name_on_card");

    private By cardNumber =
            By.name("card_number");

    private By cvc =
            By.name("cvc");

    private By expiryMonth =
            By.name("expiry_month");

    private By expiryYear =
            By.name("expiry_year");

    private By payButton =
            By.id("submit");

    private By orderPlaced =
            By.xpath("//p[contains(text(),'order has been placed successfully')]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    public boolean isAddressVisible() {
        return wait.waitForVisibility(addressDetails).isDisplayed();
    }

    public boolean isReviewOrderVisible() {
        return wait.waitForVisibility(reviewOrder).isDisplayed();
    }

    public void enterComment(String value) {
        wait.waitForVisibility(comment).sendKeys(value);
    }

    public void clickPlaceOrder() {
        wait.waitForClickable(placeOrder).click();
    }

    public void enterPaymentDetails(
            String name,
            String number,
            String cvcValue,
            String month,
            String year) {

        wait.waitForVisibility(cardName).sendKeys(name);
        wait.waitForVisibility(cardNumber).sendKeys(number);
        wait.waitForVisibility(cvc).sendKeys(cvcValue);
        wait.waitForVisibility(expiryMonth).sendKeys(month);
        wait.waitForVisibility(expiryYear).sendKeys(year);
    }

    public void pay() {
        wait.waitForClickable(payButton).click();
    }

    public boolean isOrderPlaced() {
        try {
            wait.waitForVisibility(
                    By.xpath("//p[contains(text(),'order has been placed successfully')]")
            );
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}