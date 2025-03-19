package elements;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class LoginPageElement {

    public LoginPageElement(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(10)")
    public WebElement email;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(13)")
    public WebElement password;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(15)")
    public WebElement loginButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enter your password to log in\")")
    public WebElement emptyPasswordErrorMessage;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enter your username, email or mobile number to log in\")")
    public WebElement emptyEmailErrorMessage;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/message\")")
    public WebElement wrongCredentialErrorMessage;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement credentialErrorMessageButton;
}
