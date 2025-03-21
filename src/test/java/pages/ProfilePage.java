package pages;

import elements.ProfilePageElement;
import utility.Utility;

public class ProfilePage extends Utility {
    ProfilePageElement profilePageElement = new ProfilePageElement();

    public String instagramProfileVerification() {
        return getTextElement(profilePageElement.instagramText);
    }

    public void followInstagram() {
        clickElementWithWait(profilePageElement.followButton);
    }

    public void firstPostActions() {
        clickElementWithWait(profilePageElement.firstPost);
        clickElementWithWait(profilePageElement.likeButton);
        clickElementWithWait(profilePageElement.saveButton);
    }
}