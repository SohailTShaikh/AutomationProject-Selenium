package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.TestData;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutFlow() {

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

        ProductsPage productsPage =
                loggedInHome.clickProducts();

        productsPage.hoverAndAddProduct(0);

        CartPage cartPage =
                productsPage.clickViewCart();

        assertTrue(
                cartPage.getCartProductCount() > 0
        );

        cartPage.clickProceedToCheckout();

        CheckoutPage checkoutPage =
                new CheckoutPage(driver);

        System.out.println(
                "CHECKOUT URL: " + driver.getCurrentUrl()
        );

        System.out.println(
                driver.findElement(
                        org.openqa.selenium.By.tagName("body")
                ).getText()
        );

        assertTrue(
                checkoutPage.isAddressVisible()
        );

        assertTrue(
                checkoutPage.isReviewOrderVisible()
        );
    }
}