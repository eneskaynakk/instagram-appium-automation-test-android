package elements;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class MessagePageElement {

    public MessagePageElement() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    @AndroidFindBy(id = "com.instagram.android:id/header_text")
    public WebElement messagesText;

    @AndroidFindBy(id = "com.instagram.android:id/pog_bubble_text")
    public WebElement noteBox;

    @AndroidFindBy(id = "com.instagram.android:id/music_note_button_image_view")
    public WebElement musicButton;

    @AndroidFindBy(id = "com.instagram.android:id/row_search_edit_text")
    public WebElement musicsSearchBox;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Üzerime Kalır\").instance(0)")
    public WebElement music;

    @AndroidFindBy(id = "com.instagram.android:id/action_bar_button_action")
    public WebElement musicCompletedButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Share\")")
    public WebElement shareButton;

    @AndroidFindBy(id = "com.instagram.android:id/pog_music_note_artist_name")
    public WebElement musicArtistText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"omrkasap_\").instance(1)")
    public WebElement myMessageBox;

    @AndroidFindBy(id = "com.instagram.android:id/row_thread_composer_edittext")
    public WebElement messageWritingBox;

    @AndroidFindBy(id = "com.instagram.android:id/row_thread_composer_send_button_icon")
    public WebElement sendMessageButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Hello, how are you\")")
    public WebElement myMessage;
}