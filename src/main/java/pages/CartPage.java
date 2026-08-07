package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CartPage {

    private WebDriver driver;
    private WaitUtils wait;

    private By cartTitle =
            By.xpath("//li[contains(@class,'active') and contains(text(),'Shopping Cart')]");

    private By cartRows =
            By.cssSelector("#cart_info_table tbody tr");

    private By proceedCheckout =
            By.xpath("//a[contains(text(),'Proceed To Checkout')]");

    private By emptyCart =
            By.xpath("//b[contains(text(),'Cart is empty')]");

    private By deleteFirstProduct =
            By.xpath("(//a[contains(@class,'cart_quantity_delete')])[1]");

    private By productQuantity =
            By.cssSelector(".cart_quantity button");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    public boolean isCartVisible() {
        return wait.waitForVisibility(cartTitle).isDisplayed();
    }

    public int getCartProductCount() {
        return driver.findElements(cartRows).size();
    }

    public void clickProceedToCheckout() {
        wait.waitForClickable(proceedCheckout).click();
    }

    public void removeFirstProduct() {
        wait.waitForClickable(deleteFirstProduct).click();
    }

    public boolean isCartEmpty() {
        return wait.waitForVisibility(emptyCart).isDisplayed();
    }

    public String getFirstProductQuantity() {
        return wait.waitForVisibility(productQuantity).getText();
    }
}