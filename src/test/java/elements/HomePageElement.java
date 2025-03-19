package elements;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class HomePageElement {

    public HomePageElement(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Your story\")")
    public WebElement accountText;

}
