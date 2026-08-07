package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest extends BaseTest {

    @Test
    public void addProductsToCart() {

        HomePage homePage =
                new HomePage(driver);

        ProductsPage productsPage =
                homePage.clickProducts();

        productsPage.hoverAndAddProduct(0);

        productsPage.clickContinueShopping();

        productsPage.hoverAndAddProduct(1);

        CartPage cartPage =
                homePage.clickCart();

        assertTrue(
                cartPage.getCartProductCount() >= 2
        );
    }

    @Test
    public void verifyProductQuantity() {

        HomePage homePage =
                new HomePage(driver);

        ProductsPage productsPage =
                homePage.clickProducts();

        ProductDetailsPage details =
                productsPage.clickFirstProduct();

        details.setQuantity("4");

        details.addToCart();

        productsPage.clickViewCart();

        CartPage cartPage =
                new CartPage(driver);

        assertEquals(
                "4",
                cartPage.getFirstProductQuantity()
        );
    }

    @Test
    public void removeProductFromCart() {

        HomePage homePage =
                new HomePage(driver);

        ProductsPage productsPage =
                homePage.clickProducts();

        productsPage.hoverAndAddProduct(0);

        productsPage.clickViewCart();

        CartPage cartPage =
                new CartPage(driver);

        assertTrue(
                cartPage.getCartProductCount() > 0
        );

        cartPage.removeFirstProduct();

        assertTrue(
                cartPage.isCartEmpty()
        );
    }

    @Test
    public void verifyMultipleProductsInCart() {

        HomePage homePage = new HomePage(driver);

        ProductsPage productsPage =
                homePage.clickProducts();

        productsPage.hoverAndAddProduct(0);

        productsPage.clickContinueShopping();

        productsPage.hoverAndAddProduct(1);

        CartPage cartPage =
                homePage.clickCart();

        assertEquals(
                2,
                cartPage.getCartProductCount()
        );
    }
}