package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class ProductDetailsPage {

    private WebDriver driver;
    private WaitUtils wait;

    private By productName =
            By.xpath("//div[contains(@class,'product-information')]/h2");

    private By category =
            By.xpath("//div[contains(@class,'product-information')]/p[1]");

    private By price =
            By.xpath("//div[contains(@class,'product-information')]/span/span");

    private By quantity =
            By.id("quantity");

    private By addToCart =
            By.xpath("//button[contains(@class,'cart')]");

    private By reviewTitle =
            By.xpath("//a[contains(text(),'Write Your Review')]");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    public String getProductName() {
        return wait.waitForVisibility(productName).getText();
    }

    public String getCategory() {
        return wait.waitForVisibility(category).getText();
    }

    public String getPrice() {
        return wait.waitForVisibility(price).getText();
    }

    public void setQuantity(String value) {
        wait.waitForVisibility(quantity).clear();
        wait.waitForVisibility(quantity).sendKeys(value);
    }

    public void addToCart() {
        wait.waitForClickable(addToCart).click();
    }

    public boolean isReviewVisible() {
        return wait.waitForVisibility(reviewTitle).isDisplayed();
    }
}