package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.MessagePage;

public class MessagePageStepDef {
    MessagePage messagePage = new MessagePage();
    private final Logger logger = LogManager.getLogger(MessagePageStepDef.class.getName());

    @Given("Instagram message page opens")
    public void instagramMessagePageOpens() {
        messagePage.goToMessagePage();
        logger.info("Instagram message page opens");
    }

    @Then("Message page is verified")
    public void userShouldSeeTheText() {
        String actualResult = messagePage.messagePageVerification();
        String expectedMessageText = "Messages";
        Assert.assertEquals(actualResult, expectedMessageText);
        logger.info("Message page is verified");
    }

    @When("Click on the Note button and then add the music {string} and the {string} note")
    public void userAddsNote(String music, String note) {
        messagePage.addNote(music, note);
        logger.info("Click on the Note button and then add the music {string} and the {string} text");
    }

    @Then("Adding notes has been verified")
    public void userShouldSeeTheNote() {
        String actualResult = messagePage.addNoteVerification();
        String expectedArtistNameText = "Kubilay Karça";
        Assert.assertEquals(actualResult, expectedArtistNameText);
        logger.info("Adding notes has been verified");
    }

    @When("Go to the message box and send a message {string}")
    public void userSendsMessage(String message) {
        messagePage.sendMessage(message);
        logger.info("Go to the message box and send a message {string}");
    }

    @Then("Verify sent message")
    public void userShouldSeeTheMessage() {
        String actualResult = messagePage.verifySentMessage();
        String expectedMessage = "Hello, how are you";
        Assert.assertEquals(actualResult, expectedMessage);
        logger.info("Verify sent message");
    }
}