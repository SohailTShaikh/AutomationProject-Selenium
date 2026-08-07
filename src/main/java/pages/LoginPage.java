package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class LoginPage {

    private WebDriver driver;
    private WaitUtils wait;

    private By loginEmail =
            By.xpath("//input[@data-qa='login-email']");

    private By loginPassword =
            By.xpath("//input[@data-qa='login-password']");

    private By loginButton =
            By.xpath("//button[@data-qa='login-button']");

    private By signupName =
            By.xpath("//input[@data-qa='signup-name']");

    private By signupEmail =
            By.xpath("//input[@data-qa='signup-email']");

    private By signupButton =
            By.xpath("//button[@data-qa='signup-button']");

    private By loginTitle =
            By.xpath("//h2[contains(text(),'Login to your account')]");

    private By signupTitle =
            By.xpath("//h2[contains(text(),'New User Signup')]");

    private By loginError =
            By.xpath("//p[contains(text(),'Your email or password is incorrect')]");

    private By existingEmailError =
            By.xpath("//p[contains(text(),'Email Address already exist')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    public boolean isLoginTitleVisible() {
        return wait.waitForVisibility(loginTitle).isDisplayed();
    }

    public boolean isSignupTitleVisible() {
        return wait.waitForVisibility(signupTitle).isDisplayed();
    }

    public void enterLoginEmail(String email) {
        wait.waitForVisibility(loginEmail).sendKeys(email);
    }

    public void enterLoginPassword(String password) {
        wait.waitForVisibility(loginPassword).sendKeys(password);
    }

    public HomePage clickLogin() {
        wait.waitForClickable(loginButton).click();
        return new HomePage(driver);
    }

    public HomePage login(String email, String password) {
        enterLoginEmail(email);
        enterLoginPassword(password);
        return clickLogin();
    }

    public void enterSignupName(String name) {
        wait.waitForVisibility(signupName).sendKeys(name);
    }

    public void enterSignupEmail(String email) {
        wait.waitForVisibility(signupEmail).sendKeys(email);
    }

    public SignupPage clickSignup() {
        wait.waitForClickable(signupButton).click();
        return new SignupPage(driver);
    }

    public SignupPage signup(String name, String email) {
        enterSignupName(name);
        enterSignupEmail(email);
        return clickSignup();
    }

    public String getLoginError() {
        return wait.waitForVisibility(loginError).getText();
    }

    public String getExistingEmailError() {
        return wait.waitForVisibility(existingEmailError).getText();
    }

    public boolean isLoginSuccessful() {
        return driver.getCurrentUrl().equals("https://www.automationexercise.com/");
    }
}