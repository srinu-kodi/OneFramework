package stepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import framework.core.AppiumServer;
import framework.core.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {

    @Before
    public void beforeClass() {
        System.out.println("Initializing the driver instance");
    }

    @Before({"@android", "~@web", "~@ios", "~@ignore"})
    public void beforeAndroidTestsRun() throws IOException {
        System.out.println("Running the android test scenarios");
        DriverManager.driverType = "android";
        AppiumServer.start();
        DriverManager.startAUT();
    }

    @Before({"@ios", "~@android", "~@web", "~@ignore"})
    public void beforeIOSTestsRun() throws IOException {
        System.out.println("Running the ios test scenarios");
        DriverManager.driverType = "ios";
        AppiumServer.start();
        DriverManager.startAUT();
    }

    @Before({"@web", "~@android", "~@ios", "~@ignore"})
    public void beforeWebTestsRun() throws MalformedURLException {
        System.out.println("Running the web test scenarios");
        DriverManager.driverType = "web";
        DriverManager.startAUT();
    }

    @After({"@android", "~@web", "~@ios", "~@ignore"})
    public void afterAndroidTestsRun() throws IOException {
        AppiumServer.stop();
        System.out.println("Closing the android session");
    }

    @After({"@ios", "~@android", "~@web", "~@ignore"})
    public void afterIOSTestsRun() throws IOException {
        AppiumServer.stop();
        System.out.println("Closing the ios session");
    }

    @After({"@web", "~@android", "~@ios", "~@ignore"})
    public void afterWebTestsRun() {
        System.out.println("Closing the web session");
        DriverManager.getWebDriver().quit();
    }
}