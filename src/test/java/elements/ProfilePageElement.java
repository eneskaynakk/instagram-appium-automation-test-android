package elements;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class ProfilePageElement {

    public ProfilePageElement() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    @AndroidFindBy(id = "com.instagram.android:id/action_bar_title")
    public WebElement instagramText;

    @AndroidFindBy(id = "com.instagram.android:id/profile_header_follow_button")
    public WebElement followButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Reel by Instagram at row 1, column 1\")")
    public WebElement firstPost;

    @AndroidFindBy(id = "com.instagram.android:id/row_feed_button_like")
    public WebElement likeButton;

    @AndroidFindBy(id = "com.instagram.android:id/row_feed_button_save")
    public WebElement saveButton;
}