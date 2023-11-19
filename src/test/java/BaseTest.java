import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikum.diplom3.WebDriverFactory;

import java.time.Duration;

public class BaseTest {
    WebDriver webDriver;
    @Before
    public void setup(){
        String browserName = System.getProperty("browserName");
        webDriver = WebDriverFactory.get(browserName);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void clean(){
        webDriver.quit();
    }
}
