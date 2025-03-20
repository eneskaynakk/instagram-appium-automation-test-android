package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;

public class HomePageStepDef {
    HomePage homePage = new HomePage();

    @Given("Instagram application homepage opens")
    public void instagramHomePageOpens() {
        System.out.println("You are on the Instagram homepage");
    }

    @When("Post is liked")
    public void postLiked() {
        homePage.postIsLiked();
    }

    @And("Go to post comment")
    public void userClicksOnPostCommentButton() {
        homePage.goToPostComment();
    }

    @Then("Comment pop-up verified")
    public void commentPopupShouldBeDisplayed() {
        String actualResult = homePage.commentPopupVerification();
        String expectedCommentPopupText = "Comments";
        Assert.assertEquals(actualResult, expectedCommentPopupText);
    }

    @When("Write {string} in the comment box and close the pop-up")
    public void userWritesCommentOnThePost(String comment) {
        homePage.commentOnThePost(comment);
    }

    @When("Click the send button to get the link to the post")
    public void userClicksOnShareButton() {
        homePage.goToPostLink();
    }

    @Then("The post link popup is verified")
    public void theShareButtonTextShouldBe() {
        String actualResult = homePage.postLinkVerification();
        String expectedCopyLinkText = "Copy link";
        Assert.assertEquals(actualResult, expectedCopyLinkText);
    }

    @When("Post link copied and popup closed")
    public void userCopiesThePostLink() {
        homePage.postLinkCopied();
    }

    @And("Click on anyone's story button on the home page")
    public void userClicksOnStory() {
        homePage.clickOnStory();
    }
}
