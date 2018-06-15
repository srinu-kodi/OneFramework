package framework.core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    static AndroidDriver androidDriver;
    static IOSDriver iosDriver;
    static WebDriver webDriver;

    public static String driverType;

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static AndroidDriver getAndroidDriver() {
        return androidDriver;
    }

    public static IOSDriver getIOSDriver() {
        return iosDriver;
    }

    public static void startAUT() throws MalformedURLException {
        if (driverType.equals("web")) {
            System.out.println("webdriver will start now");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/dependency/chromedriver_mac");
            webDriver = new ChromeDriver();
            DriverManager.webDriver = webDriver;
            webDriver.get("https://www.copaair.com/en/web/us");
        } else if (driverType.equals("android")) {
            DesiredCapabilities androidCapabilities = new DesiredCapabilities();
            androidCapabilities.setCapability("deviceName", "Pixel");
            androidCapabilities.setCapability("device", "Android");
            androidCapabilities.setCapability("platformName", "Android");
            androidCapabilities.setCapability("app", System.getProperty("user.dir") + "/artifacts/CopaAirlines.apk");
            androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), androidCapabilities);
            WebDriverWait androidWait = new WebDriverWait(androidDriver, 30);
        } else if (driverType.equals("ios")) {
            DesiredCapabilities iosCapabilities = new DesiredCapabilities();
            iosCapabilities.setCapability("deviceName", "iPhone 5s");
            iosCapabilities.setCapability("platformName", "iOS");
            iosCapabilities.setCapability("platformVersion", "9.3");
            iosCapabilities.setCapability("automationName", "XCUITest");
            iosCapabilities.setCapability("udid", "1A6EFAF6-8A79-4206-9567-CCF107ACDDA5");
            iosCapabilities.setCapability("app", System.getProperty("user.dir") + "/artifacts/Delta.app");
            iosDriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), iosCapabilities);
            WebDriverWait iOSWait = new WebDriverWait(iosDriver, 30);
        } else {
            System.out.println("Unable to set driver type");
        }
    }
}
