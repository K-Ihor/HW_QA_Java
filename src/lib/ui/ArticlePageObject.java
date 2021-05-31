package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;

abstract public class ArticlePageObject extends MainPageObject
{
    protected static String
        FOLDER_NAME_TPL,
        TITLE,
        FOOTER_ELEMENT,
        OPTIONS_BUTTON,
        ADD_TO_MY_LIST_BUTTON,
        ADD_TO_MY_LIST_OVERLAY,
        MY_LIST_NAME_INPUT,
        MY_LIST_OK_BUTTON,
        CLOSE_ARTICLE_BUTTON;

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
        if(Platform.getInstance().isAndroid()){
            return title_element.getAttribute("text");
        }else {
            return title_element.getAttribute("name");
        }
    }

    public void swipeToFooter()
    {
        if(Platform.getInstance().isAndroid()){
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Can`t find the end of article",
                    40
            );
        }else {
            this.swipeUpTillElementAppear(FOOTER_ELEMENT,
                    "Cant find the  and of article",
                    40);
        }
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

    public void addArticlesToMySaved()
    {
        this.waitForElementAndClick(ADD_TO_MY_LIST_BUTTON,
                "Cant find option to add article to reading list",
                5
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











