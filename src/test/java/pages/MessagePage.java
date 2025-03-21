package pages;

import elements.HomePageElement;
import elements.MessagePageElement;
import utility.Utility;

public class MessagePage extends Utility {
    HomePageElement homePageElement = new HomePageElement();
    MessagePageElement messagePageElement = new MessagePageElement();

    public void goToMessagePage() {
        clickElementWithWait(homePageElement.messagePageButton);
    }

    public String messagePageVerification() {
        return getTextElement(messagePageElement.messagesText);
    }

    public void addNote(String music, String note) {
        clickElementWithWait(messagePageElement.noteBox);

        clickElementWithWait(messagePageElement.musicButton);
        clickElementWithWait(messagePageElement.musicsSearchBox);
        sendKeyToElement(messagePageElement.musicsSearchBox, music);
        clickElementWithWait(messagePageElement.music);
        clickElementWithWait(messagePageElement.musicCompletedButton);

        sendKeyToElement(messagePageElement.noteBox, note);
        clickElementWithWait(messagePageElement.shareButton);
    }

    public String addNoteVerification() {
        return getTextElement(messagePageElement.musicArtistText);
    }

    public void sendMessage(String message) {
        clickElementWithWait(messagePageElement.myMessageBox);
        clickElementWithWait(messagePageElement.messageWritingBox);
        sendKeyToElement(messagePageElement.messageWritingBox, message);
        clickElementWithWait(messagePageElement.sendMessageButton);
    }

    public String verifySentMessage() {
        return getTextElement(messagePageElement.myMessage);
    }
}