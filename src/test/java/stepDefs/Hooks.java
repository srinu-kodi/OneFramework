package stepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    AndroidDriver androidDriver;
    IOSDriver iosDriver;
    WebDriver webDriver;

    //String strOS = System.getenv("os.name");

    @Before
    public void beforeClass() {
        System.out.println("Initializing the driver instance");
    }

    @Before({"@android", "~@web", "~@ios", "~@ignore"})
    public void beforeAndroidTestsRun() {
        System.out.println("Running the android test scenarios");
    }

    @Before({"@ios", "~@android", "~@web", "~@ignore"})
    public void beforeIOSTestsRun() {
        System.out.println("Running the ios test scenarios");
    }

    @Before({"@web", "~@android", "~@ios", "~@ignore"})
    public void beforeWebTestsRun() {
        System.out.println("Running the web test scenarios");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/dependency/chromedriver_mac");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.copaair.com/en/web/us");
    }

    @After({"@android", "~@web", "~@ios", "~@ignore"})
    public void afterAndroidTestsRun() {
        System.out.println("Closing the android session");
    }

    @After({"@ios", "~@android", "~@web", "~@ignore"})
    public void afterIOSTestsRun() {
        System.out.println("Closing the ios session");
    }

    @After({"@web", "~@android", "~@ios", "~@ignore"})
    public void afterWebTestsRun() {
        webDriver.quit();
        System.out.println("Closing the web session");
    }

}