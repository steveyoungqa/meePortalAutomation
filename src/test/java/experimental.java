import com.applitools.eyes.RectangleSize;
import cucumber.api.Scenario;
import org.junit.After;
import org.junit.Test;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import supportFactory.WebdriverFactory;
import com.applitools.eyes.Eyes;


public class experimental {

    Eyes eyes = new Eyes();


    public static WebDriver webDriver;

    @Test
    public void eyesTest () {
        webDriver = new ChromeDriver();
        eyes.setApiKey("MY_API_KEY");
        webDriver = eyes.open(webDriver, "SteveTest", "Test Web page", new RectangleSize(1024, 768));

        webDriver.get("http://applitools.com");
        eyes.checkWindow("Main Page");
        webDriver.findElement(By.cssSelector(".features>a")).click();
        eyes.checkWindow("Features page");

        eyes.close();
    }

    @After
    public void after() {
        webDriver.quit();
    }


}
