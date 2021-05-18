package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject
{
    private static final String
        FOLDER_NAME_TPL = "xpath://android.widget.TextView[@text='{IN_FOLDER}']",
        TITLE = "id:org.wikipedia:id/view_page_title_text",
        FOOTER_ELEMENT = "xpath://*[@text='View page in browser']",
        OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']",
        ADD_TO_MY_LIST_BUTTON = "xpath://android.widget.TextView[@text='Add to reading list']",
        ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button",
        MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
        MY_LIST_OK_BUTTON = "xpath://*[@text='OK']",
        CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc=\"Navigate up\"]";

    private static String getFolderByName(String in_folder)
    {
        return FOLDER_NAME_TPL.replace("{IN_FOLDER}", in_folder);
    }

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE, "Can`t find article title on page!", 25);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                FOOTER_ELEMENT,
                "Can`t find the end of article",
                10
        );
    }

    public void createMyListAndAddArticle(String name_of_folder)
    {
        this.waitForElementPresent(
                TITLE,
                "Can`t find article title",
                30
        );

        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                30
        );

        this.waitForElementPresent(
                ADD_TO_MY_LIST_BUTTON,
                "Add to reading list BUTTON not present",
                10
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_BUTTON,
                "Cannot find options Add to reading list",
                15
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find Got it tip overlay",
                10
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set of article folder",
                10
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into articles folder input",
                10
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press OK button",
                10
        );
    }

    public void addArticleToMyList(String in_folder)
    {
        this.waitForElementPresent(
                OPTIONS_BUTTON,
                "Can`t find OPTIONS_BUTTON for add List",
                10
        );

        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                10
        );

        this.waitForElementPresent(
                ADD_TO_MY_LIST_BUTTON,
                "Add to reading list BUTTON not present",
                15
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_BUTTON,
                "Cannot find options Add to reading list",
                15
        );

        String folder_name = getFolderByName(in_folder);
        this.waitForElementAndClick(
                folder_name,
                "Cannot find save list",
                10
        );
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot find button X",
                10
        );
    }
}











