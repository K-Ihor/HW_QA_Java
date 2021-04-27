import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Test;

public class FirstTest extends CoreTestCase {

    private MainPageObject MainPageObject;

    protected void setUp() throws Exception
    {
        super.setUp();

        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testFirstTest()
    {
        System.out.println("First test run");
    }

//    @Test
//    public void testCheck_text()
//    {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//        SearchPageObject.initSearchInput();
//        SearchPageObject.assertElementHesText("Search…", "Search…");
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Can`t find search Wikipedia input",
//                5
//        );
//
//        MainPageObject.assertElementHesText(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                "Search…",
//                "We see unexpected 'text'",
//                15
//        );
//    }

//    @Test
//    public void testCheckAndCancelSearch()
//    {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//        SearchPageObject.initSearchInput();
//        SearchPageObject.typeSearchLine("Java");
//        SearchPageObject.assertElementHesText("Java version history", "Java version history");
//        SearchPageObject.clickCancelSearch();
//        SearchPageObject.assertElementHesText("Search…", "Search…");
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Can`t find search Wikipedia input",
//                5
//        );
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                "Java",
//                "Can`t find search input",
//                5
//        );
//
//        MainPageObject.assertElementHesText(
//                By.xpath("//*[contains(@text, 'Java') and contains(@text, 'Java version history')]"),
//                "Java version history",
//                "Title with this text not found",
//                10
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/search_close_btn"),
//                "Can`t find 'X to cancel search'",
//                5
//        );
//
//        MainPageObject.assertElementHesText(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                "Search…",
//                "Title with this text not found",
//                5
//        );
//
//    }
//
//    @Test
//    public void testCheckingWordsInSearch() {
//
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//        SearchPageObject.initSearchInput();
//        SearchPageObject.typeSearchLine("Java");
//        SearchPageObject.getAmountOfFoundArticle();
//        SearchPageObject.CheckWordInSearchResult("Java");
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Can`t find search Wikipedia input",
//                5
//        );
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                "Java",
//                "Can`t find search input",
//                10
//        );
//
//        MainPageObject.waitForElementPresent(
//                By.id("org.wikipedia:id/page_list_item_title"),
//                "Element Not Present",
//                5
//        );
//
//        List<WebElement> searchResult = driver.findElements(By.id("org.wikipedia:id/page_list_item_title"));
//        for (WebElement i : searchResult) {
//            String element = i.getText();
//            String substring = "java";
//            if (element.toLowerCase().contains(substring)) {
//                System.out.println("ok");
//            } else {
//                Assert.assertEquals(
//                        "Article isn`t contains 'java'",
//                        substring,
//                        element
//                );
//            }
//        }
//    }

//    @Test
//    public void test_save_of_2_articles()
//    {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//        SearchPageObject.initSearchInput();
//        SearchPageObject.typeSearchLine("Java");
//        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
//
//        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
//        ArticlePageObject.createMyListAndAddArticle("Learning programing");
//        ArticlePageObject.closeArticle();
//
//        SearchPageObject.initSearchInput();
//        SearchPageObject.typeSearchLine("Java");
//        SearchPageObject.clickByArticleWithSubstring("Java");
//        ArticlePageObject.addArticleToMyList("Learning programing");
//        ArticlePageObject.closeArticle();
//
//        NavigationUI NavigationUI = new NavigationUI(driver);
//        NavigationUI.clickMyLists();
//
//        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
//        MyListsPageObject.openFolderByName("Learning programing");
//        MyListsPageObject.swipeByArticleToDelete("Java");
//        MyListsPageObject.waitForArticleToDisappearByTitle("Java");
//        MyListsPageObject.waitForArticleToAppearByTitle("Java (programming language)");
//        SearchPageObject.assertElementHesText("Java (programming language)", "Java (programming language)");
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Can`t find search Wikipedia input",
//                10
//        );
//        String search_line = "Java";
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                search_line,
//                "Can`t find search input",
//                10
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
//                "Can`t find search Wikipedia input 'Object-oriented programming language'",
//                10
//        );
//
//        MainPageObject.waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Can`t find article title",
//                30
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
//                "Cannot find button to open article options",
//                10
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.TextView[@text='Add to reading list']"),
//                "Cannot find options Add to reading list",
//                10
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/onboarding_button"),
//                "Cannot find Got it tip overlay",
//                10
//        );
//
//        MainPageObject.waitForElementAndClear(
//                By.id("org.wikipedia:id/text_input"),
//                "Cannot find input to set of article folder",
//                10
//        );
//
//        String name_of_folder = "Learning programing";
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.id("org.wikipedia:id/text_input"),
//                name_of_folder,
//                "Cannot put text into articles folder input",
//                10
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text='OK']"),
//                "Cannot press OK button",
//                10
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Can`t find search Wikipedia input",
//                10
//        );
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                search_line,
//                "Can`t find search input",
//                10
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.TextView[@text='Java']"),
//                "Can`t find search Wikipedia input 'Java'",
//                10
//        );
//
//        MainPageObject.waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Can`t find article title Java",
//                30
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
//                "Cannot find button to open article options",
//                10
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.TextView[@text='Add to reading list']"),
//                "Cannot find options Add to reading list",
//                10
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.TextView[@text='"+ name_of_folder +"']"),
//                "Cannot find save list",
//                10
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
//                "Cannot find button X",
//                10
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.id("My lists"),
//                "Cannot find navigation button to My list",
//                10
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.TextView[@text='"+ name_of_folder +"']"),
//                "Cannot find list",
//                10
//        );
//
//        MainPageObject.swipeElementToLeft(
//                By.xpath("//android.widget.TextView[@text='Java']"),
//                "Cannot find save article"
//
//        );
//
//        MainPageObject.waitForElementNotPresent(
//                By.xpath("//android.widget.TextView[@text='Java']"),
//                "Cannot delete saved article",
//                10
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.TextView[@text='Java (programming language)']"),
//                "Can`t find 'Object-oriented programming language' in My list",
//                10
//        );
//
//        MainPageObject.assertElementHesText(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Java (programming language)",
//                "We see unexpected 'text'",
//                10
//        );
//    }
//
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Can`t find search Wikipedia input",
//                10
//        );
//        String search_line = "Java";
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                search_line,
//                "Can`t find search input",
//                10
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
//                "Can`t find search Wikipedia input 'Object-oriented programming language'",
//                20
//        );
//
//        String title_article = MainPageObject.waitForElementAndGetAttribute(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "text",
//                "Can`t find article title",
//                5
//        );
//
//        Assert.assertTrue("title_article != 'Java (programming language)'", title_article.contains("Java (programming language)"));
//    }

// тест отрабатывает testCheckSearchArticleInBackground() только на 9-ом андроиде

//    @Test
//    public void testCheckSearchArticleInBackground()
//    {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//        SearchPageObject.initSearchInput();
//        SearchPageObject.typeSearchLine("Java");
//        SearchPageObject.waitForSearchResult("Object-oriented programming language");
//        this.backgroundApp(5); // поломано , уходит в бэкграунд и тест падает on 10 android
//        SearchPageObject.waitForSearchResult("Object-oriented programming language");
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Can`t find search Wikipedia input",
//                10
//        );
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                "Java",
//                "Can`t find search input",
//                15
//        );
//
//        MainPageObject.swipeUpToFindElement(
//                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
//                "Cannot find of the article",
//                20
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Programming language')]"),
//                "Can`t find search Wikipedia input",
//                15
//        );
//
//        MainPageObject.waitForElementPresent(
//                By.xpath("//*[contains(@text,'JavaScript')]"),
//                "Can`t find article after returning from background 1",
//                15
//        );
//
//        driver.runAppInBackground(5); // поломано , уходит в бэкграунд и тест падает.
//
//        MainPageObject.waitForElementPresent(
//                By.xpath("//*[contains(@text,'JavaScript')]"),
//                "Can`t find article after returning from background 2",
//                15
//        );
//    }
}

//*[@text='Object-oriented programming language']/preceding-sibling::*[@text='Java (programming language)']

