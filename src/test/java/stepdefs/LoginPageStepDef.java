package stepdefs;

import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginPageStepDef {
    LoginPage loginPage = new LoginPage();

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
        loginPage.fillMail();
    }

    /*
    @When("Login with only password")
    public void passwordOnlyLoginTest() {
        loginPage.fillMail();
    }

    @Then("Verification of error message stating that email is required")
    public void loginTestVerificationByPasswordOnly() {
        loginPage.fillMail();
    }

    @When("Login with both incorrect username and password")
    public void invalidCredentialsLoginTest() {
        loginPage.fillMail();
    }

    @Then("Verification of error message stating that email and password are required")
    public void invalidCredentialsLoginTestVerification() {
        loginPage.fillMail();
    }

    @When("Login with correct email and password")
    public void successfulLoginTest() {
        loginPage.fillMail();
    }

    @Then("Verification of successful login")
    public void successfulLoginTestVerification() {
        loginPage.fillMail();
    }*/
}