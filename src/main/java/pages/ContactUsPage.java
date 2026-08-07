package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class ContactUsPage {

    private WebDriver driver;
    private WaitUtils wait;

    private By getInTouch =
            By.xpath("//h2[contains(text(),'Get In Touch')]");

    private By name =
            By.name("name");

    private By email =
            By.name("email");

    private By subject =
            By.name("subject");

    private By message =
            By.id("message");

    private By uploadFile =
            By.name("upload_file");

    private By submit =
            By.name("submit");

    private By successMessage =
            By.xpath("//div[contains(@class,'status') and contains(text(),'Success!')]");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    public boolean isGetInTouchVisible() {
        return wait.waitForVisibility(getInTouch).isDisplayed();
    }

    public void enterName(String value) {
        wait.waitForVisibility(name).sendKeys(value);
    }

    public void enterEmail(String value) {
        wait.waitForVisibility(email).sendKeys(value);
    }

    public void enterSubject(String value) {
        wait.waitForVisibility(subject).sendKeys(value);
    }

    public void enterMessage(String value) {
        wait.waitForVisibility(message).sendKeys(value);
    }

    public void uploadFile(String path) {
        wait.waitForVisibility(uploadFile).sendKeys(path);
    }

    public void submit() {
        wait.waitForClickable(submit).click();
    }

    public String getSuccessMessage() {
        return wait.waitForVisibility(successMessage).getText();
    }
}