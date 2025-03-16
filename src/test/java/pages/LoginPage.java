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
        doubleClickElement(loginPageElement.loginButton);
    }

    public void fillPassword() {
        clickElementWithWait(loginPageElement.password);
        sendKeyToElement(loginPageElement.password, userLoginPassword);
        clickElementWithWait(loginPageElement.loginButton);
    }

    public void wrongEmailOrPassword() {
        clickElementWithWait(loginPageElement.email);
        sendKeyToElement(loginPageElement.email, userLoginEmail);
        clickElementWithWait(loginPageElement.password);
        sendKeyToElement(loginPageElement.password, "wrong_password");
        clickElementWithWait(loginPageElement.loginButton);
    }

    public void loginProcess() {
        clickElementWithWait(loginPageElement.email);
        sendKeyToElement(loginPageElement.email, userLoginEmail);
        clickElementWithWait(loginPageElement.password);
        sendKeyToElement(loginPageElement.password, userLoginPassword);
        clickElementWithWait(loginPageElement.loginButton);
    }


}
