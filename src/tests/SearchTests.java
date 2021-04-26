package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase
{
    @Test
    public void testCheck_text()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.assertElementHesText("Search…", "Search…");

    }

    @Test
    public void testCheckAndCancelSearch()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.assertElementHesText("Java version history", "Java version history");
        SearchPageObject.clickCancelSearch();
        SearchPageObject.assertElementHesText("Search…", "Search…");
    }

    @Test
    public void testCheckingWordsInSearch()
    {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.getAmountOfFoundArticle();
        SearchPageObject.CheckWordInSearchResult("Java");
    }
}
