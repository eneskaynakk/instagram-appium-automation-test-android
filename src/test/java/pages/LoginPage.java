package pages;

import elements.LoginPageElement;
import utility.ConfigReader;
import utility.Utility;

public class LoginPage extends Utility {
    LoginPageElement loginPageElement = new LoginPageElement();
    private final String userLoginEmail = ConfigReader.getProperty("email");
    private final String userLoginPassword = ConfigReader.getProperty("password");

    public void fillMail() {
        clickElementWithWait(loginPageElement.email);
        sendKeyToElement(loginPageElement.email, userLoginEmail);
        clickElementWithWait(loginPageElement.password);
        clickElementWithWait(loginPageElement.loginButton);
    }

    public String emptyPasswordControl() {
        return getTextElement(loginPageElement.emptyPasswordErrorMessage);
    }

    public void clearEmailBox() {
        clickElementWithWait(loginPageElement.email);
        clearInputElement(loginPageElement.email);
    }

    public void fillPassword() {
        clickElementWithWait(loginPageElement.password);
        sendKeyToElement(loginPageElement.password, userLoginPassword);
        clickElementWithWait(loginPageElement.email);
        clickElementWithWait(loginPageElement.loginButton);
    }

    public String emptyEmailControl() {
        return getTextElement(loginPageElement.emptyEmailErrorMessage);
    }

    public void getCredentialErrorMessageButton() {
        clickElementWithWait(loginPageElement.credentialErrorMessageButton);
    }

    public void clearPasswordBox() {
        clickElementWithWait(loginPageElement.password);
        clearInputElement(loginPageElement.password);
    }

    public void wrongEmailOrPassword() {
        clickElementWithWait(loginPageElement.email);
        sendKeyToElement(loginPageElement.email, userLoginEmail);
        clickElementWithWait(loginPageElement.password);
        sendKeyToElement(loginPageElement.password, "wrong_password");
        clickElementWithWait(loginPageElement.loginButton);
    }

    public String wrongEmailOrPasswordControl() {
        return getTextElement(loginPageElement.wrongCredentialErrorMessage);
    }

    public void loginProcess() {
        clickElementWithWait(loginPageElement.email);
        sendKeyToElement(loginPageElement.email, userLoginEmail);
        clickElementWithWait(loginPageElement.password);
        sendKeyToElement(loginPageElement.password, userLoginPassword);
        clickElementWithWait(loginPageElement.loginButton);
    }
}
