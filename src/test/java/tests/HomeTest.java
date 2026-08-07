package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeTest extends BaseTest {

    @Test
    public void verifyHomePage() {

        HomePage homePage = new HomePage(driver);

        assertTrue(homePage.isHomePageVisible());
    }

    @Test
    public void verifyTestCasesPage() {

        HomePage homePage = new HomePage(driver);

        homePage.clickTestCases();

        assertTrue(
                driver.getCurrentUrl().contains("test_cases")
        );
    }
}