package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigationTest extends BaseTest {

    @Test
    public void verifyHomePageNavigation() {

        HomePage homePage = new HomePage(driver);

        assertEquals(
                "https://www.automationexercise.com/",
                driver.getCurrentUrl()
        );

        assertTrue(
                homePage.isHomeVisible()
        );
    }

    @Test
    public void verifyProductsNavigation() {

        HomePage homePage = new HomePage(driver);

        ProductsPage productsPage =
                homePage.clickProducts();

        assertTrue(
                driver.getCurrentUrl().contains("/products")
        );

        assertTrue(
                productsPage.isProductsPageVisible()
        );
    }

    @Test
    public void verifySignupLoginNavigation() {

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage =
                homePage.clickSignupLogin();

        assertTrue(
                driver.getCurrentUrl().contains("/login")
        );

        assertTrue(
                loginPage.isLoginFormVisible()
        );
    }

    @Test
    public void verifyCartNavigation() {

        HomePage homePage = new HomePage(driver);

        homePage.clickCart();

        assertTrue(
                driver.getCurrentUrl().contains("/view_cart")
        );
    }

    @Test
    public void verifyContactUsNavigation() {

        HomePage homePage = new HomePage(driver);

        homePage.clickContactUs();

        assertTrue(
                driver.getCurrentUrl().contains("/contact_us")
        );
    }
}