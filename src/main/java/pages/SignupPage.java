package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.WaitUtils;

public class SignupPage {

    private WebDriver driver;
    private WaitUtils wait;

    private By accountInformation =
            By.xpath("//h2[contains(normalize-space(.),'Enter Account Information')]");
    private By male =
            By.id("id_gender1");

    private By female =
            By.id("id_gender2");

    private By password =
            By.id("password");

    private By days =
            By.id("days");

    private By months =
            By.id("months");

    private By years =
            By.id("years");

    private By newsletter =
            By.id("newsletter");

    private By specialOffers =
            By.id("optin");

    private By firstName =
            By.id("first_name");

    private By lastName =
            By.id("last_name");

    private By company =
            By.id("company");

    private By address =
            By.id("address1");

    private By address2 =
            By.id("address2");

    private By country =
            By.id("country");

    private By state =
            By.id("state");

    private By city =
            By.id("city");

    private By zipcode =
            By.id("zipcode");

    private By mobile =
            By.id("mobile_number");

    private By createAccount =
            By.xpath("//button[@data-qa='create-account']");

    private By accountCreated =
            By.xpath("//h2//b[contains(normalize-space(.),'Account Created')]");

    private By continueButton =
            By.xpath("//a[contains(normalize-space(.),'Continue')]");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    public boolean isAccountInformationVisible() {
        return wait.waitForVisibility(accountInformation).isDisplayed();
    }

    public void selectMale() {
        wait.waitForClickable(male).click();
    }

    public void selectFemale() {
        wait.waitForClickable(female).click();
    }

    public void enterPassword(String value) {
        wait.waitForVisibility(password).sendKeys(value);
    }

    public void selectDay(String value) {
        new Select(wait.waitForVisibility(days))
                .selectByValue(value);
    }

    public void selectMonth(String value) {
        new Select(wait.waitForVisibility(months))
                .selectByValue(value);
    }

    public void selectYear(String value) {
        new Select(wait.waitForVisibility(years))
                .selectByValue(value);
    }

    public void selectNewsletter() {
        if (!driver.findElement(newsletter).isSelected()) {
            ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript(
                            "arguments[0].click();",
                            driver.findElement(newsletter)
                    );
        }
    }

    public void selectSpecialOffers() {
        if (!driver.findElement(specialOffers).isSelected()) {
            ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript(
                            "arguments[0].click();",
                            driver.findElement(specialOffers)
                    );
        }
    }

    public void enterFirstName(String value) {
        wait.waitForVisibility(firstName).sendKeys(value);
    }

    public void enterLastName(String value) {
        wait.waitForVisibility(lastName).sendKeys(value);
    }

    public void enterCompany(String value) {
        wait.waitForVisibility(company).sendKeys(value);
    }

    public void enterAddress(String value) {
        wait.waitForVisibility(address).sendKeys(value);
    }

    public void enterAddress2(String value) {
        wait.waitForVisibility(address2).sendKeys(value);
    }

    public void selectCountry(String value) {
        new Select(wait.waitForVisibility(country))
                .selectByVisibleText(value);
    }

    public void enterState(String value) {
        wait.waitForVisibility(state).sendKeys(value);
    }

    public void enterCity(String value) {
        wait.waitForVisibility(city).sendKeys(value);
    }

    public void enterZipcode(String value) {
        wait.waitForVisibility(zipcode).sendKeys(value);
    }

    public void enterMobile(String value) {
        wait.waitForVisibility(mobile).sendKeys(value);
    }

    public void clickCreateAccount() {
        wait.waitForClickable(createAccount).click();
    }

    public boolean isAccountCreated() {
        wait.waitForUrlContains("account_created");

        String pageText = driver.findElement(By.tagName("body")).getText();

        boolean result = pageText.matches("(?s).*ACCOUNT\\s+CREATED.*");

        System.out.println("Account Created Verification: " + result);

        return result;
    }

    public HomePage clickContinue() {
        wait.waitForClickable(continueButton).click();
        return new HomePage(driver);
    }
}