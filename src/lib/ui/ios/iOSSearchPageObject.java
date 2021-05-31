package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject
{
    static {
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia'])";
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@value='Search Wikipedia'])";
        SEARCH_CANCEL_BUTTON = "id:Close";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "xpath:////XCUIElementTypeLink";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='No results found']";
        FIND_TEXT_TPL = "xpath://*[contains(@text, '{SUBSTRING}')]"; // XPath аписан по андроид тест, нужно переписать
        FIND_TITLE_AND_DESCRIPTION = "xpath://*[@text='{DESCRIPTION}']/preceding-sibling::*[@text='{TITLE}']"; // XPath аписан по андроид тест, нужно переписать
    }

    public iOSSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}










