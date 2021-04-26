package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject
{
    private static final String
        TITLE = "org.wikipedia:id/view_page_title_text",
        FOOTER_ELEMENT = "//*[@text='View page in browser']",
        OPTIONS_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
        ADD_TO_MY_LIST_BUTTON = "//android.widget.TextView[@text='Add to reading list']",
        ADD_TO_MY_LIST_OVERLAY = "org.wikipedia:id/onboarding_button",
        MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
        MY_LIST_OK_BUTTON = "//*[@text='OK']",
        CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]";

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(By.id(TITLE), "Can`t find article title on page!", 25);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                By.xpath(FOOTER_ELEMENT),
                "Can`t find the end of article",
                10
        );
    }

    public void createMyListAndAddArticle(String name_of_folder)
    {
        this.waitForElementPresent(
                By.id(TITLE),
                "Can`t find article title",
                30
        );

        this.waitForElementAndClick(
                By.xpath(OPTIONS_BUTTON),
                "Cannot find button to open article options",
                30
        );

        this.waitForElementPresent(
                By.xpath(ADD_TO_MY_LIST_BUTTON),
                "Add to reading list BUTTON not present",
                10
        );

        this.waitForElementAndClick(
                By.xpath(ADD_TO_MY_LIST_BUTTON),
                "Cannot find options Add to reading list",
                15
        );

        this.waitForElementAndClick(
                By.id(ADD_TO_MY_LIST_OVERLAY),
                "Cannot find Got it tip overlay",
                10
        );

        this.waitForElementAndClear(
                By.id(MY_LIST_NAME_INPUT),
                "Cannot find input to set of article folder",
                10
        );

        this.waitForElementAndSendKeys(
                By.id(MY_LIST_NAME_INPUT),
                name_of_folder,
                "Cannot put text into articles folder input",
                10
        );

        this.waitForElementAndClick(
                By.xpath(MY_LIST_OK_BUTTON),
                "Cannot press OK button",
                10
        );
    }

    public void addArticleToMyList(String in_folder)
    {
        this.waitForElementPresent(
                By.xpath(OPTIONS_BUTTON),
                "Can`t find OPTIONS_BUTTON for add List",
                10
        );

        this.waitForElementAndClick(
                By.xpath(OPTIONS_BUTTON),
                "Cannot find button to open article options",
                10
        );

        this.waitForElementPresent(
                By.xpath(ADD_TO_MY_LIST_BUTTON),
                "Add to reading list BUTTON not present",
                10
        );

        this.waitForElementAndClick(
                By.xpath(ADD_TO_MY_LIST_BUTTON),
                "Cannot find options Add to reading list",
                10
        );

        this.waitForElementAndClick(
                By.xpath("//android.widget.TextView[@text='"+ in_folder +"']"),
                "Cannot find save list",
                10
        );
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                By.xpath(CLOSE_ARTICLE_BUTTON),
                "Cannot find button X",
                10
        );
    }
}











