package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ProfilePage;
import pages.SearchPage;

public class ProfilePageStepDef {
    SearchPage searchPage = new SearchPage();
    ProfilePage profilePage = new ProfilePage();

    @Given("Instagram search page is opened")
    public void instagramMessagePageOpens() {
        searchPage.goToSearchPage();
    }

    @Then("Instagram search page verified")
    public void userShouldSeeTheSearchText() {
        String actualResult = searchPage.instagramSearchPageVerification();
        String expectedInstagramText = "Search";
        Assert.assertEquals(actualResult, expectedInstagramText);
    }

    @When("{string} is entered into the search bar")
    public void searchIsMade(String profileName) {
        searchPage.profileSearch(profileName);
    }

    @And("Instagram profile page is navigated")
    public void goToSearchedProfile() {
        searchPage.goToInstagramProfile();
    }

    @Then("Instagram profile is verified")
    public void searchedProfileVerification() {
        String actualResult = profilePage.instagramProfileVerification();
        String expectedProfileName = "instagram";
        Assert.assertEquals(actualResult, expectedProfileName);
    }

    @When("Instagram page is followed by clicking the follow button")
    public void followProfile() {
        profilePage.followInstagram();
    }

    @And("First post is liked and saved")
    public void postActions() {
        profilePage.firstPostActions();
    }
}
