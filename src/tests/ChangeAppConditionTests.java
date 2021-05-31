package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ChangeAppConditionTests extends CoreTestCase
{
    // тест отрабатывает testCheckSearchArticleInBackground() только на 9-ом андроиде
    @Test
    public void testCheckSearchArticleInBackground() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        this.backgroundApp(5); // поломано , уходит в бэкграунд и тест падает on 10 android
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }
}
