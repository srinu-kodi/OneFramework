package tests;

import org.oneframework.core.AndroidBuilder;
import org.oneframework.core.AppiumServer;
import org.oneframework.core.IPhoneBuilder;
import org.oneframework.core.WebDriverBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {
    public WebDriver driver;

    @Parameters({"platformType", "platformName"})
    @BeforeTest
    public void startAppiumServer(String platformType, @Optional String platformName) throws IOException {
        if (platformType.equalsIgnoreCase("mobile")) {
            if (AppiumServer.appium == null || !AppiumServer.appium.isRunning()) {
                AppiumServer.start();
            }
        }
    }

    @Parameters({"platformType", "platformName"})
    @AfterTest
    public void stopAppiumServer(String platformType, @Optional String platformName) throws IOException {
        if (platformType.equalsIgnoreCase("mobile")) {
            if (AppiumServer.appium != null || AppiumServer.appium.isRunning()) {
                AppiumServer.stop();
            }
        }
    }

    @Parameters({"platformType", "platformName"})
    @BeforeMethod
    public void setupDriver(String platformType, String platformName) throws IOException {
        if (platformType.equalsIgnoreCase("web")) {
            setupWebDriver(platformName);
        } else if (platformType.equalsIgnoreCase("mobile")) {
            setupMobileDriver(platformName);
        }
    }

    public void setupMobileDriver(String platformName) throws MalformedURLException {
        if (platformName.equalsIgnoreCase("android")) {
            driver = new AndroidBuilder().setupDriver();
        } else if (platformName.equalsIgnoreCase("iphone")) {
            driver = new IPhoneBuilder().setupDriver();
        }
    }

    public void setupWebDriver(String platformName) throws MalformedURLException {
        if (platformName.equalsIgnoreCase("chrome")) {
            driver = new WebDriverBuilder().setupDriver("chrome");
        } else if (platformName.equalsIgnoreCase("firefox")) {
            driver = new WebDriverBuilder().setupDriver("firefox");
        }
        driver.get("https://www.wordpress.com");
    }

    @AfterMethod
    public void teardownWebDriver() {
        driver.quit();
    }

}