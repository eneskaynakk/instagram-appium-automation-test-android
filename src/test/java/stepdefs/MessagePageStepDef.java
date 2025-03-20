package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.MessagePage;

public class MessagePageStepDef {
    MessagePage messagePage = new MessagePage();

    @Given("Instagram message page opens")
    public void instagramMessagePageOpens(){
        messagePage.goToMessagePage();
    }

    @Then("Message page is verified")
    public void userShouldSeeTheText(){
        String actualResult = messagePage.messagePageVerification();
        String expectedMessageText = "Messages";
        Assert.assertEquals(actualResult, expectedMessageText);
    }

    @When("Click on the Note button and then add the music {string} and the {string} text")
    public void userAddsNote(String music, String note){
        messagePage.addNote(music, note);
    }

    @Then("Adding notes has been verified")
    public void userShouldSeeTheNote(){
        String actualResult = messagePage.addNoteVerification();
        String expectedArtistNameText = "Kubilay Karça";
        Assert.assertEquals(actualResult, expectedArtistNameText);
    }

    @When("Go to the message box and send a message {string}")
    public void userSendsMessage(String message){
        messagePage.sendMessage(message);
    }

    @Then("Verify sent message")
    public void userShouldSeeTheMessage(){
        String actualResult = messagePage.verifySentMessage();
        String expectedMessage = "Hello, how are you";
        Assert.assertEquals(actualResult, expectedMessage);
    }
}
