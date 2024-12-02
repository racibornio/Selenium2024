import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebDriver chromeDriver = new ChromeDriver();
        driver.get("http://e.pl");
        System.out.println("Mamy strone " + driver.getTitle());
        driver.quit();
    }
}
