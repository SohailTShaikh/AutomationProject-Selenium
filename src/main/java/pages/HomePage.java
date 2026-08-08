package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class HomePage {

    private WebDriver driver;
    private WaitUtils wait;

    private By signupLogin =
            By.xpath("//a[contains(text(),'Signup / Login')]");

    private By logout =
            By.xpath("//a[contains(text(),'Logout')]");

    private By deleteAccount =
            By.xpath("//a[contains(text(),'Delete Account')]");

    private By products =
            By.xpath("//a[contains(text(),'Products')]");

    private By cart =
            By.xpath("//a[contains(text(),'Cart')]");

    private By contactUs =
            By.xpath("//a[contains(text(),'Contact us')]");

    private By testCases =
            By.xpath("//a[contains(text(),'Test Cases')]");

    private By loggedInUser =
            By.xpath("//a[contains(.,'Logged in as')]");

    private By homeText =
            By.xpath("//h2[contains(text(),'Full-Fledged practice website')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    private By home =
            By.xpath("//a[contains(text(),'Home')]");

    public void logout() {
        wait.waitForClickable(logout).click();
    }

    public void deleteAccount() {
        wait.waitForClickable(deleteAccount).click();
        wait.waitForUrlContains("delete_account");
    }

    public void clickTestCases() {
        wait.waitForClickable(testCases).click();
    }

    public boolean isLoggedIn() {
        String pageText =
                driver.findElement(By.tagName("body")).getText();

        return pageText.contains("Logged in as");
    }

    public boolean isHomePageVisible() {
        return wait.waitForVisibility(homeText).isDisplayed();
    }

    public boolean isAccountDeleted() {
        wait.waitForUrlContains("delete_account");

        String text = driver.findElement(By.tagName("body")).getText();

        return text.matches("(?s).*ACCOUNT\\s+DELETED.*");
    }

    public ProductsPage clickProducts() {
        wait.waitForClickable(products).click();
        return new ProductsPage(driver);
    }

    public LoginPage clickSignupLogin() {
        wait.waitForClickable(signupLogin).click();
        return new LoginPage(driver);
    }

    public CartPage clickCart() {
        wait.waitForClickable(cart).click();
        return new CartPage(driver);
    }

    public void clickContactUs() {
        wait.waitForClickable(contactUs).click();
    }

    public boolean isHomeVisible() {
        return wait.waitForVisibility(home).isDisplayed();
    }
}