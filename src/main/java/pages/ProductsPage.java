package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.WaitUtils;

import java.util.List;

public class ProductsPage {

    private WebDriver driver;
    private WaitUtils wait;

    private By productsTitle =
            By.xpath("//h2[contains(text(),'All Products')]");

    private By searchInput =
            By.id("search_product");

    private By searchButton =
            By.id("submit_search");

    private By searchedProducts =
            By.xpath("//h2[contains(text(),'Searched Products')]");

    private By productItems =
            By.cssSelector(".product-image-wrapper");

    private By firstViewProduct =
            By.xpath("(//a[contains(text(),'View Product')])[1]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    private By continueShopping =
            By.xpath("//button[contains(text(),'Continue Shopping')]");

    public boolean isProductsPageVisible() {
        return wait.waitForVisibility(productsTitle).isDisplayed();
    }

    public boolean isSearchedProductsVisible() {
        return wait.waitForVisibility(searchedProducts).isDisplayed();
    }

    public int getProductCount() {
        return driver.findElements(productItems).size();
    }

    public ProductDetailsPage clickFirstProduct() {
        wait.waitForClickable(firstViewProduct).click();
        return new ProductDetailsPage(driver);
    }

    public void hoverAndAddProduct(int index) {

        List<WebElement> products =
                driver.findElements(productItems);

        WebElement product = products.get(index);

        new Actions(driver)
                .moveToElement(product)
                .perform();

        product.findElement(
                By.xpath(".//a[contains(text(),'Add to cart')]")
        ).click();
    }

    public void clickContinueShopping() {
        By continueShopping =
                By.xpath("//button[contains(.,'Continue Shopping')]");

        wait.waitForClickable(continueShopping).click();
    }

    public CartPage clickViewCart() {
        By viewCart =
                By.xpath("//u[contains(normalize-space(.),'View Cart')]");

        wait.waitForVisibility(viewCart).click();

        return new CartPage(driver);
    }

    public void searchProduct(String productName) {
        By searchBox = By.id("search_product");
        By searchButton = By.id("submit_search");

        wait.waitForVisibility(searchBox).sendKeys(productName);
        wait.waitForClickable(searchButton).click();
    }

    public boolean isSearchResultsVisible() {
        By searchedProducts =
                By.xpath("//h2[contains(normalize-space(.),'Searched Products')]");

        return wait.waitForVisibility(searchedProducts).isDisplayed();
    }
}