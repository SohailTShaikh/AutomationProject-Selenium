package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.ContactUsPage;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactUsTest extends BaseTest {

    @Test
    public void contactUsForm() {

        HomePage homePage =
                new HomePage(driver);

        homePage.clickContactUs();

        ContactUsPage contactUsPage =
                new ContactUsPage(driver);

        assertTrue(
                contactUsPage.isGetInTouchVisible()
        );

        contactUsPage.enterName("Sohail");

        contactUsPage.enterEmail(
                "sohail@example.com"
        );

        contactUsPage.enterSubject(
                "Automation Testing"
        );

        contactUsPage.enterMessage(
                "This is a Selenium automation test."
        );

        contactUsPage.uploadFile(
                "/home/sohail/test.txt"
        );

        contactUsPage.submit();

        driver.switchTo()
                .alert()
                .accept();

        assertTrue(
                contactUsPage.getSuccessMessage()
                        .contains(
                                "successfully"
                        )
        );
    }
}