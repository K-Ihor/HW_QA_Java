package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

abstract public class SearchPageObject extends MainPageObject
{
    protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESULT_ELEMENT,
            SEARCH_EMPTY_RESULT_ELEMENT,
            FIND_TEXT_TPL,
            FIND_TITLE_AND_DESCRIPTION;

    public SearchPageObject(AppiumDriver driver) // берем драйвер из MainPageObject
    {
        super(driver);
    }

    // TPL
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getSearchElementText(String searchedElementByText)
    {
        return FIND_TEXT_TPL.replace("{SUBSTRING}", searchedElementByText);
    }

    private static String getResultByTitleAndDescription(String TITLE, String DESCRIPTION)
    {
        return FIND_TITLE_AND_DESCRIPTION.replace("{TITLE}", TITLE).replace("{DESCRIPTION}", DESCRIPTION);
    }
    // TPL

    public void initSearchInput()
    {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Can`t find and click search init element", 10);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Can`t find search input after clicking search init element");
    }

    public void waitForCancelButtonToAppear()
    {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Can`t find search cancel button", 10);
    }

    public void waitForCancelButtonToDisappear()
    {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present", 10);
    }

    public void clickCancelSearch()
    {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Can`t find and click cancel button", 10);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Can`t find and type into search input", 10);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Can`t find search result with substring" + substring);
    }

    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Can`t find and click search result with substring" + substring, 10);
    }

    public int getAmountOfFoundArticle()
    {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by the request",
                20
        );
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }

    public void waitForEmptyResultLabel()
    {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT, "Cannot find empty result element", 15);
    }

    public void assertElementNotPresent()
    {
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed not find any results");
    }

    public void assertElementHesText(String searchedElementByText, String assert_text)
    {
        String findInArticle = getSearchElementText(searchedElementByText);
        this.assertElementHesText(findInArticle, assert_text, "We see unexpected 'text'", 15);
    }

    public void CheckWordInSearchResult(String substring)
    {
        List<WebElement> searchResult = driver.findElements(By.id(SEARCH_RESULT_ELEMENT));
        for (WebElement i : searchResult) {
            String element = i.getText();
            String t = substring;
            if (element.toLowerCase().contains(t)) {
                System.out.println("ok");
            } else {
                Assert.assertEquals(
                        "Article isn`t contains " + substring,
                        substring,
                        element
                );
            }
        }
    }

    public void waitForElementByTitleAndDescription(String TITLE, String DESCRIPTION)
    {
        String findArticle = getResultByTitleAndDescription(TITLE, DESCRIPTION);
        this.waitForElementPresent(
                findArticle,
                "Can`t find Article by TITLE and DESCRIPTION",
                15
        );
    }

}
