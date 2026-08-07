package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignupPage;
import utils.TestData;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignupTest extends BaseTest {

    @Test
    public void registerUser() {

        String email = TestData.getUniqueEmail();

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = homePage.clickSignupLogin();

        assertTrue(loginPage.isSignupTitleVisible(), "Signup title failed");

        SignupPage signupPage =
                loginPage.signup(TestData.FIRST_NAME, email);

        assertTrue(
                signupPage.isAccountInformationVisible(),
                "Account information page failed"
        );

        signupPage.selectMale();
        signupPage.enterPassword(TestData.PASSWORD);

        signupPage.selectDay("10");
        signupPage.selectMonth("5");
        signupPage.selectYear("1998");

        signupPage.selectNewsletter();
        signupPage.selectSpecialOffers();

        signupPage.enterFirstName(TestData.FIRST_NAME);
        signupPage.enterLastName(TestData.LAST_NAME);
        signupPage.enterCompany(TestData.COMPANY);
        signupPage.enterAddress(TestData.ADDRESS);
        signupPage.enterAddress2(TestData.ADDRESS2);

        signupPage.selectCountry(TestData.COUNTRY);
        signupPage.enterState(TestData.STATE);
        signupPage.enterCity(TestData.CITY);
        signupPage.enterZipcode(TestData.ZIPCODE);
        signupPage.enterMobile(TestData.MOBILE);

        signupPage.clickCreateAccount();

        boolean accountCreated = signupPage.isAccountCreated();

        System.out.println("TEST RECEIVED ACCOUNT CREATED: " + accountCreated);

        assertTrue(accountCreated, "Account creation verification failed");

        HomePage loggedInHome = signupPage.clickContinue();

        boolean loggedIn = loggedInHome.isLoggedIn();

        System.out.println("TEST RECEIVED LOGGED IN: " + loggedIn);

        assertTrue(loggedIn, "Login verification failed");

        loggedInHome.deleteAccount();

        boolean accountDeleted = loggedInHome.isAccountDeleted();

        System.out.println(
                "TEST RECEIVED ACCOUNT DELETED: " + accountDeleted
        );

        assertTrue(
                accountDeleted,
                "Account deletion verification failed"
        );
    }
}