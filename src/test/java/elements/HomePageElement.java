package elements;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class HomePageElement {

    public HomePageElement() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Your story\")")
    public WebElement accountText;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Like\"]")
    public WebElement likeButton;

    @AndroidFindBy(id = "com.instagram.android:id/row_feed_button_comment")
    public WebElement commentButton;

    @AndroidFindBy(id = "com.instagram.android:id/title_text_view")
    public WebElement commentTextVerification;

    @AndroidFindBy(id = "com.instagram.android:id/search_tab")
    public WebElement commentBox;

    @AndroidFindBy(id = "com.instagram.android:id/tab_avatar")
    public WebElement sendCommentButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Send post\"]")
    public WebElement shareButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Copy link\")")
    public WebElement linkCopiedButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"spotify's story, 1 of 2, Seen.\"]")
    public WebElement storyButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.instagram.android:id/story_item_cta_container\"]/android.widget.LinearLayout")
    public WebElement storyNextButton;

    @AndroidFindBy(id = "com.instagram.android:id/action_bar_inbox_button")
    public WebElement messagePageButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.instagram.android:id/tab_icon\").instance(2)")
    public WebElement searchPageButton;
}