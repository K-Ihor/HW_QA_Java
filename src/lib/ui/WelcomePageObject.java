package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject
{
    private static final String
            STEP_LEARN_MORE_LINK = "id:Learn more about Wikipedia",
            STEP_NEW_WAYS_TO_EXPLORE_TEXT = "id:New way to explore",
            STEP_ADD_OR_EDIT_PREFERRED = "id:Add or edit preferred languages",
            STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "id:Learn more about date collected",
            NEXT_LINK = "id:Next",
            GET_STARTED_BUTTON = "id:Get started",
            SKIP = "id:Skip";

    public WelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void waitForLearnMoreLink()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_LINK, "Can`t find 'Learn more about Wikipedia' link", 15);
    }

    public void waitForNewWayToExploreText()
    {
        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE_TEXT, "Can`t find 'New way to explore' link", 15);
    }

    public void waitForAddOrEditPreferredLangText()
    {
        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREFERRED, "Can`t find 'Add or edit preferred languages' link", 15);
    }

    public void waitForLearnMoreAboutDateCollectedText()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK, "Can`t find 'Learn more about date collected' link", 15);
    }

    public void clickNextButton()
    {
        this.waitForElementAndClick(NEXT_LINK, "Can`t find and click 'Next' link", 15);
    }

    public void clickGetStartedButton()
    {
        this.waitForElementAndClick(GET_STARTED_BUTTON, "Can`t find and click 'Get started' link", 15);
    }

    public void clickSkip()
    {
        this.waitForElementAndClick(SKIP, "Cant find and click SKIP button", 10);
    }
}
