import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MechBudWebDriver {

    static WebDriver chromeDriver;

    @BeforeAll
    static void setupClass() {
        // 1. Mechanizm budowania WebDriver
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        chromeDriver = RemoteWebDriver.builder().oneOf(new ChromeOptions()).build();
    }

    @AfterEach
    void tearDown() {
        chromeDriver.quit();
    }

    @Test
    void Test() {
        chromeDriver.get("http://e.pl");
        System.out.println("MechBudWebDriver otwiera " + chromeDriver.getTitle());
    }

}
