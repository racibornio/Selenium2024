import io.github.bonigarcia.wdm.WebDriverManager;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.util.List;
import java.util.Set;

public class Epl {

    static WebDriver chromeDriver;
    String suturl = "http://e.pl";

    @BeforeAll
    static void setupClass() {
        // 1. Mechanizm budowania WebDriver
        //WebDriverManager.chromedriver().setup();

        // ten jest silniejszy niz "WebDriverManager.chromedriver().setup();" bo rozwiazuje sterownik, ale i tworzy
        // instancje wlasciwego typu WebDriver, przy czym obiekt klasy WebDriver zainstancjonowany na
        // poczatku musi byc statycznym; mozna tez wtedy pominac metode build() pisana w BeforeEach - i
        // cala ta adnotacje - pod warunkiem przypisania od razu wyniku dzialnia metody inicjujacej w @BeforeAll do
        // zmiennej sterownika przegladarki
        chromeDriver = WebDriverManager.chromedriver().create();
    }

//    @BeforeEach
//    void setup() {
//        chromeDriver = RemoteWebDriver.builder().oneOf(new ChromeOptions()).build();
//    }

    @Test
    void Test() {
        chromeDriver.get(suturl);
        SessionId sessionId = ((RemoteWebDriver) chromeDriver).getSessionId();
        System.out.println("ID sesji to " + sessionId);
        System.out.println("Tytu? otwartej strony to " + chromeDriver.getTitle());

    }

    @AfterEach
    void tearDown() {
        chromeDriver.quit();
    }

}
