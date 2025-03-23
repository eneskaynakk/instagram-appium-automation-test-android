package stepdefs;

import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageStepDef {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    private final Logger logger = LogManager.getLogger(LoginPageStepDef.class.getName());

    @Given("Instagram login page opens")
    public void instagramApp() {
        logger.info("You are on the Instagram login page");
    }

    @When("Login with only email")
    public void emailOnlyLoginTest() {
        loginPage.fillMail();
        logger.info("Login with only email");
    }

    @Then("Verification of error message stating password is required")
    public void loginTestVerificationByEmailOnly() {
        String actualResult = loginPage.emptyPasswordControl();
        String expectedErrorMessage = "Enter your password to log in";
        Assert.assertEquals(actualResult, expectedErrorMessage);
        loginPage.getCredentialErrorMessageButton();

        loginPage.clearEmailBox();
        logger.info("Verification of error message stating password is required");
    }

    @When("Login with only password")
    public void passwordOnlyLoginTest() {
        loginPage.fillPassword();
        logger.info("Login with only password");
    }

    @Then("Verification of error message stating that email is required")
    public void loginTestVerificationByPasswordOnly() {
        String actualResult = loginPage.emptyEmailControl();
        String expectedErrorMessage = "Enter your username, email or mobile number to log in";
        Assert.assertEquals(actualResult, expectedErrorMessage);
        loginPage.getCredentialErrorMessageButton();

        loginPage.clearPasswordBox();
        logger.info("Verification of error message stating that email is required");
    }

    @When("Login with both incorrect username and password")
    public void invalidCredentialsLoginTest() {
        loginPage.wrongEmailOrPassword();
        logger.info("Login with both incorrect username and password");
    }

    @Then("Verification of error message stating that email and password are required")
    public void invalidCredentialsLoginTestVerification() {
        String actualResult = loginPage.wrongEmailOrPasswordControl();
        String expectedErrorMessage = "The password you entered is incorrect. Please try again.";
        Assert.assertEquals(actualResult, expectedErrorMessage);
        loginPage.getCredentialErrorMessageButton();

        logger.info("Verification of error message stating that email and password are required");
    }

    @When("Login with correct email and password")
    public void successfulLoginTest() {
        loginPage.loginProcess();
        logger.info("Login with correct email and password");
    }

    @Then("Verification of successful login")
    public void successfulLoginTestVerification() {
        String actualResult = homePage.successfulLoginVerification();
        String expectedAccountText = "Your story";
        Assert.assertEquals(actualResult, expectedAccountText);
        logger.info("Verification of successful login");
    }
}