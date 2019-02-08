package tests;

import org.oneframework.drivers.AndroidDriverBuilder;
import org.oneframework.appium.AppiumServer;
import org.oneframework.drivers.IOSDriverBuilder;
import org.oneframework.drivers.WebDriverBuilder;
import org.oneframework.enums.PlatformName;
import org.oneframework.enums.PlatformType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

import static org.oneframework.logger.LoggingManager.logMessage;

public class BaseTest {
    public WebDriver driver;

    @Parameters({"platformType", "platformName"})
    @BeforeTest
    public void startAppiumServer(String platformType, @Optional String platformName) throws IOException {
        if (platformType.equalsIgnoreCase(PlatformType.MOBILE.toString())) {
            killExistingAppiumProcess();
            if (AppiumServer.appium == null || !AppiumServer.appium.isRunning()) {
                AppiumServer.start();
            }
        }
    }

    @Parameters({"platformType", "platformName"})
    @AfterTest
    public void stopAppiumServer(String platformType, @Optional String platformName) throws IOException {
        if (platformType.equalsIgnoreCase(PlatformType.MOBILE.toString())) {
            if (AppiumServer.appium != null || AppiumServer.appium.isRunning()) {
                AppiumServer.stop();
            }
        }
    }

    @Parameters({"platformType", "platformName", "model"})
    @BeforeMethod
    public void setupDriver(String platformType, String platformName, @Optional String model) throws IOException {
        if (platformType.equalsIgnoreCase(PlatformType.WEB.toString())) {
            setupWebDriver(platformName);
        } else if (platformType.equalsIgnoreCase(PlatformType.MOBILE.toString())) {
            setupMobileDriver(platformName, model);
        }
    }

    public void setupMobileDriver(String platformName, String model) throws IOException {
        if (platformName.equalsIgnoreCase(PlatformName.ANDROID.toString())) {
            driver = new AndroidDriverBuilder().setupDriver(model);
        } else if (platformName.equalsIgnoreCase(PlatformName.IOS.toString())) {
            driver = new IOSDriverBuilder().setupDriver(model);
        }
    }

    public void setupWebDriver(String platformName) throws IOException {
        if (platformName.equalsIgnoreCase(PlatformName.CHROME.toString())) {
            driver = new WebDriverBuilder().setupDriver(platformName);
        } else if (platformName.equalsIgnoreCase(PlatformName.FIREFOX.toString())) {
            driver = new WebDriverBuilder().setupDriver(platformName);
        }
        driver.get("https://www.wordpress.com");
    }

    @AfterMethod
    public void teardownDriver() {
        driver.quit();
    }

    private void killExistingAppiumProcess() throws IOException {
        Runtime.getRuntime().exec("killall node");
        logMessage("Killing existing appium process");
    }

}