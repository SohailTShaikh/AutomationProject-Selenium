package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.TestData;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage =
                homePage.clickSignupLogin();

        loginPage.login(
                TestData.LOGIN_EMAIL,
                TestData.LOGIN_PASSWORD
        );

        System.out.println("URL AFTER LOGIN: " + driver.getCurrentUrl());

        System.out.println(
                "PAGE AFTER LOGIN:\n" +
                        driver.findElement(By.tagName("body")).getText()
        );

        HomePage loggedInHome = new HomePage(driver);

        assertTrue(
                loggedInHome.isLoggedIn()
        );
    }

    @Test
    public void invalidLogin() {

        HomePage homePage =
                new HomePage(driver);

        LoginPage loginPage =
                homePage.clickSignupLogin();

        loginPage.login(
                "wrong@gmail.com",
                "wrongpassword"
        );

        assertEquals(
                "Your email or password is incorrect!",
                loginPage.getLoginError()
        );
    }

    @Test
    public void logoutUser() {

        HomePage homePage =
                new HomePage(driver);

        LoginPage loginPage =
                homePage.clickSignupLogin();

        HomePage loggedInHome =
                loginPage.login(
                        TestData.LOGIN_EMAIL,
                        TestData.LOGIN_PASSWORD
                );

        assertTrue(
                loggedInHome.isLoggedIn()
        );

        loggedInHome.logout();

        assertTrue(
                driver.getCurrentUrl()
                        .contains("/login")
        );
    }
}