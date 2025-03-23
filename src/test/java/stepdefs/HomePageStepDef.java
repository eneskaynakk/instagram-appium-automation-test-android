package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.HomePage;

public class HomePageStepDef {
    HomePage homePage = new HomePage();
    private final Logger logger = LogManager.getLogger(HomePageStepDef.class.getName());

    @Given("Instagram application homepage opens")
    public void instagramHomePageOpens() {
        logger.info("You are on the Instagram homepage");
    }

    @When("Post is liked")
    public void postLiked() {
        homePage.postIsLiked();
        logger.info("Post is liked");
    }

    @And("Go to post comment")
    public void userClicksOnPostCommentButton() {
        homePage.goToPostComment();
        logger.info("Go to post comment");
    }

    @Then("Comment pop-up verified")
    public void commentPopupShouldBeDisplayed() {
        String actualResult = homePage.commentPopupVerification();
        String expectedCommentPopupText = "Comments";
        Assert.assertEquals(actualResult, expectedCommentPopupText);
        logger.info("Comment pop-up verified");
    }

    @When("Write {string} in the comment box and close the pop-up")
    public void userWritesCommentOnThePost(String comment) {
        homePage.commentOnThePost(comment);
        logger.info("Write {string} in the comment box and close the pop-up");
    }

    @When("Click the send button to get the link to the post")
    public void userClicksOnShareButton() {
        homePage.goToPostLink();
        logger.info("Click the send button to get the link to the post");
    }

    @Then("The post link popup is verified")
    public void theShareButtonTextShouldBe() {
        String actualResult = homePage.postLinkVerification();
        String expectedCopyLinkText = "Copy link";
        Assert.assertEquals(actualResult, expectedCopyLinkText);
        logger.info("The post link popup is verified");
    }

    @When("Post link copied and popup closed")
    public void userCopiesThePostLink() {
        homePage.postLinkCopied();
        logger.info("Post link copied and popup closed");
    }

    @And("Click on anyone's story button on the home page")
    public void userClicksOnStory() {
        homePage.clickOnStory();
        logger.info("Click on anyone's story button on the home page");
    }
}