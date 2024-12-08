import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MechBudWebDriverManager {

    String sutUrl = "file:///C:/Users/pos/IdeaProjects/JAVA/src/main/java/com/patryk/Selenium2024/untitled/src/www/strona1/index.html";


    // musi byc statyczny, czyli wywolywany na rzecz klasy a nie obiektu
    static WebDriver chromeDriver;

    @BeforeAll
    static void setupClass() {
        // od razu nastepuje zainstancjonowanie obiektu dla wszystkich testow - niepotrzebna jest adnotacja @BeforeEach
        chromeDriver = WebDriverManager.chromedriver().create();
    }

    @AfterEach
    void tearDown() {
        chromeDriver.quit();
    }

    @Test
    void Test() {
        chromeDriver.get(sutUrl);
        System.out.println("MechBudWebDriverManager otwiera strone " + chromeDriver.getTitle());
        System.out.println("MechBudWebDriverManager otwiera adres " + chromeDriver.getCurrentUrl());
        WebElement pierwszeP = chromeDriver.findElement(By.tagName("p"));
        System.out.println("Tre?? akapitu to " + pierwszeP.getText() + " a tag to " + pierwszeP.getTagName());

    }
}
