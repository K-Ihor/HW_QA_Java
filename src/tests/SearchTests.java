package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class SearchTests extends CoreTestCase
{
    @Test
    public void testCheck_text()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.assertElementHesText("Search…", "Search…");

    }

    @Test
    public void testCheckAndCancelSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.assertElementHesText("Java version history", "Java version history");
        SearchPageObject.clickCancelSearch();
        SearchPageObject.assertElementHesText("Search…", "Search…");
    }

    @Test
    public void testCheckingWordsInSearch()
    {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.getAmountOfFoundArticle();
        SearchPageObject.CheckWordInSearchResult("Java");
    }

    @Test
    public void testCheckSearchResult()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Java");
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticle();
        assertTrue("Search result < 3 article", amount_of_search_results >= 3);
        SearchPageObject.waitForElementByTitleAndDescription("Java", "Island of Indonesia");
        SearchPageObject.waitForElementByTitleAndDescription("JavaScript", "Programming language");
        SearchPageObject.waitForElementByTitleAndDescription("Java (programming language)", "Object-oriented programming language");

    }
}
