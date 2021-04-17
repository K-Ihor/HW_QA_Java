import io.appium.java_client.AppiumDriver;
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
}







