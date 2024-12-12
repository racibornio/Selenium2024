import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

// Asercje - 2/3
import org.assertj.core.api.Assertions;

public class testGoogleCom {
    static WebDriver chromeDriver;
    String suturl = "https://www.google.com/";

    @BeforeAll
    static void setupClass() {
        chromeDriver = WebDriverManager.chromedriver().create();
    }

    @Test
    void TestOpenUrl() {
        chromeDriver.get(suturl);
        System.out.println("Otwarto strone " + chromeDriver.getTitle() + " z adresu " + chromeDriver.getCurrentUrl());
        String expectedUrl = suturl;
        String actualUrl = chromeDriver.getCurrentUrl();

        // Asercje - 3/3
        Assertions.assertThat(actualUrl).as("Wrong URL.").isEqualTo(expectedUrl);
    }

    @Test
    void TestOpenUrlPlusScreenshot() throws IOException {
        chromeDriver.get(suturl);
        System.out.println("Otwarto stron? " + chromeDriver.getTitle() + " z adresu " + chromeDriver.getCurrentUrl());

        File screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("./screenshots/init.png"));
    }

    @Test
    void TestOpenUrlAndScrollDownPlusScreenshot() throws IOException {
        chromeDriver.get(suturl);
        System.out.println("The page " + chromeDriver.getTitle() + " from url: " + chromeDriver.getCurrentUrl() + " " +
                "got open.");

        // take the screenshot on the page opened
        File screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("./screenshots/init.png"));
        System.out.println("The screenshot is saved.");

        // maximize the browser window
        chromeDriver.manage().window().maximize();
        System.out.println("Window maximized.");

        // wait for the UI elements
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));

        // take the screnshot on the maximized window
        screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("./screenshots/afterMaximize.png"));
        System.out.println("The screenshot is saved.");

        // scroll down to the button
        WebElement rejectButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[1]/div")));
        Actions scrollWelcomePageDown = new Actions(chromeDriver);
        scrollWelcomePageDown.moveToElement(rejectButton).perform();
        System.out.println("Navigation scrolled down.");

        // take the screenshot on the page scrolled down to the reject button
        screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("./screenshots/afterScrollDown.png"));
        System.out.println("The screenshot is saved.");

    }

    @Test
    void TestOpenUrlAndScrollDownAndRejectPlusScreenshot() throws IOException {
        chromeDriver.get(suturl);
        System.out.println("The page " + chromeDriver.getTitle() + " from url: " + chromeDriver.getCurrentUrl() + " " +
                "got open.");

        // take the screenshot on the page opened
        File screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("./screenshots/init.png"));
        System.out.println("The screenshot is saved.");

        // maximize the browser window
        chromeDriver.manage().window().maximize();
        System.out.println("Window maximized.");

        // wait for the UI elements
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));

        // take the screnshot on the maximized window
        screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("./screenshots/afterMaximize.png"));
        System.out.println("The screenshot is saved.");

        // scroll down to the button
        WebElement rejectButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[1]/div")));
        Actions scrollWelcomePageDown = new Actions(chromeDriver);
        scrollWelcomePageDown.moveToElement(rejectButton).perform();
        System.out.println("Navigation scrolled down.");

        // take the screenshot on the page scrolled down to the reject button
        screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("./screenshots/afterScrollDown.png"));
        System.out.println("The screenshot is saved.");

        // click the Reject button
        rejectButton.click();
        System.out.println("The Reject button got clicked.");

        // take the screenshot after Reject button clicked
        screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("./screenshots/afterReject.png"));
        System.out.println("The screenshot is saved.");

        // search field
        WebElement searchField = chromeDriver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[1]/div[2]/textarea"));
        searchField.click();
        System.out.println("The search field got clicked");

        screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("./screenshots/afterClickInTextField.png"));
        System.out.println("The screenshot is saved.");
    }

    @Test
    void TestToSearchAndSearchPlusScreenshot() throws IOException {
        chromeDriver.get(suturl);
        System.out.println("The page " + chromeDriver.getTitle() + " from url: " + chromeDriver.getCurrentUrl() + " " +
                "got open.");

        // take the screenshot on the page opened
        File screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("./screenshots/init.png"));
        System.out.println("The screenshot is saved.");

        // maximize the browser window
        chromeDriver.manage().window().maximize();
        System.out.println("Window maximized.");

        // wait for the UI elements
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));

        // take the screnshot on the maximized window
        screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("./screenshots/afterMaximize.png"));
        System.out.println("The screenshot is saved.");

        // scroll down to the button
        WebElement rejectButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[1]/div")));
        Actions scrollWelcomePageDown = new Actions(chromeDriver);
        scrollWelcomePageDown.moveToElement(rejectButton).perform();
        System.out.println("Navigation scrolled down.");

        // take the screenshot on the page scrolled down to the reject button
        screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("./screenshots/afterScrollDown.png"));
        System.out.println("The screenshot is saved.");

        // click the Reject button
        rejectButton.click();
        System.out.println("The Reject button got clicked.");

        // take the screenshot after Reject button clicked
        screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("./screenshots/afterReject.png"));
        System.out.println("The screenshot is saved.");

        // search field
        WebElement searchField = chromeDriver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[1]/div[2]/textarea"));
        searchField.click();
        System.out.println("The search field got clicked");

        // take the screenshot on the search page open
        screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("./screenshots/afterClickInTextField.png"));
        System.out.println("The screenshot is saved.");

        // enter the query to search
        searchField.sendKeys("how to fix broken shaft in Toyota");
        searchField.sendKeys(Keys.ENTER);

        // wait for the results
        WebElement theAllTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hdtb-sc\"]/div/div/div[1]/div/div[1]/a/div")));

        // take the screenshot on the results page
        screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("./screenshots/results.png"));
        System.out.println("The screenshot is saved.");
    }

    @Test
    void Test() throws IOException {
        //WebDriverManager.chromedriver().browserVersion("current").setup();
        WebDriverManager.chromedriver().avoidBrowserDetection().setup();

        chromeDriver.get(suturl);

        File screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("./screenshots/init.png"));

        chromeDriver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));

        screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("./screenshots/afterMaximize.png"));

        //WebElement rejectButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("QS5gu sy4vM")));
        WebElement rejectButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[1]/div")));
        Actions scrollWelcomePageDown = new Actions(chromeDriver);
        scrollWelcomePageDown.moveToElement(rejectButton).perform();

        screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("./screenshots/afterScrollDown.png"));

        //WebElement rejectButton = chromeDriver.findElement(By.cssSelector("QS5gu sy4vM"));

        rejectButton.click();
        screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("./screenshots/afterReject.png"));

        WebElement searchField = chromeDriver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[1]/div[2]/textarea"));
        searchField.click();

        screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("./screenshots/afterClickInTextField.png"));
    }

    @AfterEach
    void tearDown() {
        chromeDriver.quit();
    }
}
