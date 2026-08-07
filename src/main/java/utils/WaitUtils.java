package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    public void waitForUrl(String url) {
        wait.until(
                ExpectedConditions.urlContains(url)
        );
    }

    public void waitForUrlContains(String value) {
        wait.until(
                ExpectedConditions.urlContains(value)
        );
    }
}