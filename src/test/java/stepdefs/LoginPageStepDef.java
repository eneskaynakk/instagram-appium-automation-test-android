package stepdefs;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageStepDef {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("Instagram application opens")
    public void instagramApp() {
        System.out.println("You are on the Instagram app");
    }

    @When("Login with only email")
    public void emailOnlyLoginTest() {
        loginPage.fillMail();
    }

    @Then("Verification of error message stating password is required")
    public void loginTestVerificationByEmailOnly() {
        String actualResult = loginPage.emptyPasswordControl();
        String expectedErrorMessage = "Enter your password to log in";
        Assert.assertEquals(actualResult, expectedErrorMessage);
        loginPage.getCredentialErrorMessageButton();

        loginPage.clearEmailBox();
    }

    @When("Login with only password")
    public void passwordOnlyLoginTest() {
        loginPage.fillPassword();
    }

    @Then("Verification of error message stating that email is required")
    public void loginTestVerificationByPasswordOnly() {
        String actualResult = loginPage.emptyEmailControl();
        String expectedErrorMessage = "Enter your username, email or mobile number to log in";
        Assert.assertEquals(actualResult, expectedErrorMessage);
        loginPage.getCredentialErrorMessageButton();

        loginPage.clearPasswordBox();
    }

    @When("Login with both incorrect username and password")
    public void invalidCredentialsLoginTest() {
        loginPage.wrongEmailOrPassword();
    }

    @Then("Verification of error message stating that email and password are required")
    public void invalidCredentialsLoginTestVerification() {
        String actualResult = loginPage.wrongEmailOrPasswordControl();
        String expectedErrorMessage = "The password you entered is incorrect. Please try again.";
        Assert.assertEquals(actualResult, expectedErrorMessage);
        loginPage.getCredentialErrorMessageButton();

        loginPage.clearEmailBox();
    }

    @When("Login with correct email and password")
    public void successfulLoginTest() {
        loginPage.loginProcess();
    }

    @Then("Verification of successful login")
    public void successfulLoginTestVerification() {
        String actualResult = homePage.successfulLoginVerification();
        String expectedAccountText = "Your story";
        Assert.assertEquals(actualResult, expectedAccountText);
    }
}