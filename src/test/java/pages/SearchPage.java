package pages;

import elements.HomePageElement;
import elements.SearchPageElement;
import utility.Utility;

public class SearchPage extends Utility {
    HomePageElement homePageElement = new HomePageElement();
    SearchPageElement searchPageElement = new SearchPageElement();

    public void goToSearchPage() {
        clickElementWithWait(homePageElement.searchPageButton);
    }

    public String instagramSearchPageVerification() {
        return getTextElement(searchPageElement.searchBox);
    }

    public void profileSearch(String profileName) {
        clickElementWithWait(searchPageElement.searchBox);
        sendKeyToElement(searchPageElement.searchBox, profileName);
    }

    public void goToInstagramProfile() {
        clickElementWithWait(searchPageElement.instagramProfileButton);
    }
}