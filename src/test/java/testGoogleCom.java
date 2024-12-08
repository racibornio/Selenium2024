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

public class testGoogleCom {
    static WebDriver chromeDriver;
    String suturl = "http://google.com";

    @BeforeAll
    static void setupClass() {
        chromeDriver = WebDriverManager.chromedriver().create();
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

        Actions scrollWelcomePageDown = new Actions(chromeDriver);
        //WebElement rejectButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("QS5gu sy4vM")));
        WebElement rejectButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[1]/div")));

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
