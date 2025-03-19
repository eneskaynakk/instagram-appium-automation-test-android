package pages;

import elements.HomePageElement;
import utility.Utility;

public class HomePage extends Utility {
    HomePageElement homePageElement = new HomePageElement();

    public String successfulLoginVerification(){
        return getTextElement(homePageElement.accountText);
    }

}
