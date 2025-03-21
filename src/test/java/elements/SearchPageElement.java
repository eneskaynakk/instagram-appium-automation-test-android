package elements;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class SearchPageElement {

    public SearchPageElement() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    @AndroidFindBy(id = "com.instagram.android:id/action_bar_search_edit_text")
    public WebElement searchBox;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"instagram\")")
    public WebElement instagramProfileButton;
}