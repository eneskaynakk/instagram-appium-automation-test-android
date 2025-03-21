package pages;

import elements.HomePageElement;
import utility.Utility;

public class HomePage extends Utility {
    HomePageElement homePageElement = new HomePageElement();

    public String successfulLoginVerification() {
        return getTextElement(homePageElement.accountText);
    }

    public void postIsLiked() {
        scrollWithCoordinates(homePageElement.likeButton, 0, 136, 1080, 1739, "down", 3, 1500);
        clickElementWithWait(homePageElement.likeButton);
    }

    public void goToPostComment() {
        clickElementWithWait(homePageElement.commentButton);
    }

    public String commentPopupVerification() {
        return getTextElement(homePageElement.commentTextVerification);
    }

    public void commentOnThePost(String comment) {
        sendKeyToElement(homePageElement.commentBox, comment);
        clickElementWithWait(homePageElement.sendCommentButton);
        pressBackButton();
    }

    public void goToPostLink() {
        clickElementWithWait(homePageElement.shareButton);
    }

    public String postLinkVerification() {
        return getTextElement(homePageElement.linkCopiedButton);
    }

    public void postLinkCopied() {
        clickElementWithWait(homePageElement.linkCopiedButton);
        pressBackButton();
    }

    public void clickOnStory() {
        scrollWithCoordinates(homePageElement.accountText, 0, 767, 1080, 1080, "up", 3, 1500);
        clickElementWithWait(homePageElement.storyButton);
        clickElementWithWait(homePageElement.storyNextButton);
    }
}