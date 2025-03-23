package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.ProfilePage;
import pages.SearchPage;

public class ProfilePageStepDef {
    SearchPage searchPage = new SearchPage();
    ProfilePage profilePage = new ProfilePage();
    private final Logger logger = LogManager.getLogger(LoginPageStepDef.class.getName());

    @Given("Instagram search page is opened")
    public void instagramMessagePageOpens() {
        searchPage.goToSearchPage();
        logger.info("Instagram search page is opened");
    }

    @Then("Instagram search page verified")
    public void userShouldSeeTheSearchText() {
        String actualResult = searchPage.instagramSearchPageVerification();
        String expectedInstagramText = "Search";
        Assert.assertEquals(actualResult, expectedInstagramText);
        logger.info("Instagram search page verified");
    }

    @When("{string} is entered into the search bar")
    public void searchIsMade(String profileName) {
        searchPage.profileSearch(profileName);
        logger.info("{string} is entered into the search bar");
    }

    @And("Instagram profile page is navigated")
    public void goToSearchedProfile() {
        searchPage.goToInstagramProfile();
        logger.info("Instagram profile page is navigated");
    }

    @Then("Instagram profile is verified")
    public void searchedProfileVerification() {
        String actualResult = profilePage.instagramProfileVerification();
        String expectedProfileName = "instagram";
        Assert.assertEquals(actualResult, expectedProfileName);
        logger.info("Instagram profile is verified");
    }

    @When("Instagram page is followed by clicking the follow button")
    public void followProfile() {
        profilePage.followInstagram();
        logger.info("Instagram page is followed by clicking the follow button");
    }

    @And("First post is liked and saved")
    public void postActions() {
        profilePage.firstPostActions();
        logger.info("First post is liked and saved");
    }
}
