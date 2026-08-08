package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductTest extends BaseTest {

    @Test
    public void verifyProducts() {

        HomePage homePage = new HomePage(driver);

        ProductsPage productsPage = homePage.clickProducts();

        assertTrue(
                productsPage.isProductsPageVisible()
        );

        assertTrue(
                productsPage.getProductCount() > 0
        );
    }

    @Test
    public void searchProduct() {

        HomePage homePage =
                new HomePage(driver);

        ProductsPage productsPage =
                homePage.clickProducts();

        productsPage.searchProduct("Blue Top");

        assertTrue(
                productsPage.isSearchedProductsVisible()
        );

        assertTrue(
                productsPage.getProductCount() > 0
        );
    }

    @Test
    public void verifyProductDetails() {

        HomePage homePage =
                new HomePage(driver);

        ProductsPage productsPage =
                homePage.clickProducts();

        ProductDetailsPage productDetails =
                productsPage.clickFirstProduct();

        assertTrue(productDetails.getProductName().length() > 0);

        assertTrue(productDetails.getCategory().length() > 0);

        assertTrue(productDetails.getPrice().length() > 0);
    }
}