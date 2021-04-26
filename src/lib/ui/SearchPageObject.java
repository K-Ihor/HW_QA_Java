package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPageObject extends MainPageObject
{
    private static final String
            SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
            SEARCH_INPUT = "//*[contains(@text, 'Search…')]",
            SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[contains(@text,'{SUBSTRING}')]",
            SEARCH_RESULT_ELEMENT = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']",
            SEARCH_EMPTY_RESULT_ELEMENT = "//*[@text='No results found']",
            FIND_TEXT_TPL = "//*[contains(@text, '{SUBSTRING}')]";

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

    // TPL

    public void initSearchInput()
    {
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Can`t find and click search init element", 10);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Can`t find search input after clicking search init element");
    }

    public void waitForCancelButtonToAppear()
    {
        this.waitForElementPresent(By.id(SEARCH_CANCEL_BUTTON), "Can`t find search cancel button", 10);
    }

    public void waitForCancelButtonToDisappear()
    {
        this.waitForElementNotPresent(By.id(SEARCH_CANCEL_BUTTON), "Search cancel button is still present", 10);
    }

    public void clickCancelSearch()
    {
        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON), "Can`t find and click cancel button", 10);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line, "Can`t find and type into search input", 10);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Can`t find search result with substring" + substring);
    }

    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Can`t find and click search result with substring" + substring, 10);
    }

    public int getAmountOfFoundArticle()
    {
        this.waitForElementPresent(
                By.xpath(SEARCH_RESULT_ELEMENT),
                "Cannot find anything by the request",
                20
        );
        return this.getAmountOfElements(By.xpath(SEARCH_RESULT_ELEMENT));
    }

    public void waitForEmptyResultLabel()
    {
        this.waitForElementPresent(By.xpath(SEARCH_EMPTY_RESULT_ELEMENT), "Cannot find empty result element", 15);
    }

    public void assertElementNotPresent()
    {
        this.assertElementNotPresent(By.xpath(SEARCH_RESULT_ELEMENT), "We supposed not find any results");
    }

    public void assertElementHesText(String searchedElementByText, String assert_text)
    {
        String findInArticle = getSearchElementText(searchedElementByText);
        this.assertElementHesText(By.xpath(findInArticle), assert_text, "We see unexpected 'text'", 15);
    }

    public void CheckWordInSearchResult(String substring)
    {
        List<WebElement> searchResult = driver.findElements(By.id(SEARCH_RESULT_ELEMENT));
        for (WebElement i : searchResult) {
            String element = i.getText();
            if (element.toLowerCase().contains(substring)) {
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

}
