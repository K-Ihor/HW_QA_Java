import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FirstTest
{
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/home/ihor/JAVA/HW_QA_Java/apks/org.wikipedia.apk");
        capabilities.setCapability("avd", "and81");
        capabilities.setCapability("orientation", "PORTRAIT");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void firstTest()
    {
        System.out.println("First test run");
    }

    @Test
    public void check_text()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Can`t find search Wikipedia input",
                5
        );

        assertElementHesText(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Search…",
                "We see unexpected 'text'",
                15
        );

    }

    @Test
    public void checkAndCancelSearch()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Can`t find search Wikipedia input",
                5
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Java",
                "Can`t find search input",
                5
        );

        assertElementHesText(
                By.xpath("//*[contains(@text, 'Java') and contains(@text, 'Java version history')]"),
                "Java version history",
                "Title with this text not found",
                10
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Can`t find 'X to cancel search'",
                5
        );

        assertElementHesText(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Search…",
                "Title with this text not found",
                5
        );

    }

    @Test
    public void checkingWordsInSearch() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Can`t find search Wikipedia input",
                5
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Java",
                "Can`t find search input",
                10
        );

        waitForElementPresent(
                By.id("org.wikipedia:id/page_list_item_title"),
                "Element Not Present",
                5
        );

        List<WebElement> searchResult = driver.findElements(By.id("org.wikipedia:id/page_list_item_title"));
        for (WebElement i : searchResult) {
            String element = i.getText();
            String substring = "java";
            if (element.toLowerCase().contains(substring)) {
                System.out.println("ok");
            } else {
                Assert.assertEquals(
                        "Article isn`t contains 'java'",
                        substring,
                        element
                );
            }
        }
    }


    @Test
    public void save_of_2_articles()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Can`t find search Wikipedia input",
                10
        );
        String search_line = "Java";

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                search_line,
                "Can`t find search input",
                10
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "Can`t find search Wikipedia input 'Object-oriented programming language'",
                10
        );

        waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Can`t find article title",
                30
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find button to open article options",
                10
        );

        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@text='Add to reading list']"),
                "Cannot find options Add to reading list",
                10
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "Cannot find Got it tip overlay",
                10
        );

        waitForElementAndClear(
                By.id("org.wikipedia:id/text_input"),
                "Cannot find input to set of article folder",
                10
        );

        String name_of_folder = "Learning programing";

        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                name_of_folder,
                "Cannot put text into articles folder input",
                10
        );

        waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot press OK button",
                10
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
                "Cannot find button X",
                10
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Can`t find search Wikipedia input",
                10
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                search_line,
                "Can`t find search input",
                10
        );

        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@text='Java']"),
                "Can`t find search Wikipedia input 'Java'",
                10
        );

        waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Can`t find article title Java",
                30
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find button to open article options",
                10
        );

        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@text='Add to reading list']"),
                "Cannot find options Add to reading list",
                10
        );

        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@text='"+ name_of_folder +"']"),
                "Cannot find save list",
                10
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot find button X",
                10
        );

        waitForElementAndClick(
                By.id("My lists"),
                "Cannot find navigation button to My list",
                10
        );

        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@text='"+ name_of_folder +"']"),
                "Cannot find list",
                10
        );

        swipeElementToLeft(
                By.xpath("//android.widget.TextView[@text='Java']"),
                "Cannot find save article"

        );

        waitForElementNotPresent(
                By.xpath("//android.widget.TextView[@text='Java']"),
                "Cannot delete saved article",
                10
        );

        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@text='Java (programming language)']"),
                "Can`t find 'Object-oriented programming language' in My list",
                10
        );

        assertElementHesText(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Java (programming language)",
                "We see unexpected 'text'",
                10
        );
    }

    @Test
    public void assertElementPresent()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Can`t find search Wikipedia input",
                10
        );
        String search_line = "Java";

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                search_line,
                "Can`t find search input",
                10
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "Can`t find search Wikipedia input 'Object-oriented programming language'",
                20
        );

        String title_article = waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/view_page_title_text"),
                "text",
                "Can`t find article title",
                5
        );

        Assert.assertTrue("title_article != 'Java (programming language)'", title_article.contains("Java (programming language)"));
    }






    @Test
    public void testCheckSearchArticleInBackground()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Can`t find search Wikipedia input",
                10
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Java",
                "Can`t find search input",
                15
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "Can`t find search Wikipedia input",
                15
        );

        waitForElementPresent(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "Can`t find article after returning from background 1",
                15
        );

        driver.runAppInBackground(5); // поломано , уходит в бэкграунд и тест падает.

        waitForElementPresent(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "Can`t find article after returning from background 2",
                15
        );
    }








    private void assertElementHesText(By by, String text, String error_message, long timeoutInSeconds)
    {
        WebElement waitSearchLine = waitForElementPresent(by, error_message, timeoutInSeconds);

        String article_title = waitSearchLine.getAttribute("text");
        Assert.assertEquals(
                error_message,
                text,
                article_title
        );
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, 5);
        element.sendKeys(value);
        return element;
    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementPresent(By by, String error_message)  // перегрузка метода с выносом таймаута
    {
        return waitForElementPresent(by, error_message, 5);
    }

    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, 5);
        element.click();
        return element;
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    protected void swipeElementToLeft(By by, String error_message)
    {
        WebElement element = waitForElementPresent(
                by,
                error_message,
                10);

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x, middle_y)
                .waitAction(300)
                .moveTo(left_x, middle_y)
                .release()
                .perform();
    }

    private String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        return element.getAttribute(attribute);
    }
}







