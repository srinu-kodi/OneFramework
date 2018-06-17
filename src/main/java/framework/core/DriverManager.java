package framework.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    static AppiumDriver driver;

    public static String driverType;

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void startAUT() throws MalformedURLException {
        if (driverType.equals("android")) {
            DesiredCapabilities androidCapabilities = new DesiredCapabilities();
            androidCapabilities.setCapability("deviceName", "emulator-5554");
            androidCapabilities.setCapability("device", "Android");
            androidCapabilities.setCapability("platformName", "Android");
            androidCapabilities.setCapability("app", System.getProperty("user.dir") + "/artifacts/WordPress.apk");
            androidCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.wordpress.android");
            androidCapabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
            androidCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.wordpress.android.ui.WPLaunchActivity");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), androidCapabilities);
            WebDriverWait androidWait = new WebDriverWait(driver, 30);
        } else if (driverType.equals("ios")) {
            DesiredCapabilities iosCapabilities = new DesiredCapabilities();
            iosCapabilities.setCapability("deviceName", "iPhone 8");
            iosCapabilities.setCapability("platformName", "iOS");
            iosCapabilities.setCapability("platformVersion", "11.4");
            iosCapabilities.setCapability("automationName", "XCUITest");
            iosCapabilities.setCapability("udid", "65D41497-6506-41C3-9644-EC166EEA2159");
            iosCapabilities.setCapability("app", System.getProperty("user.dir") + "/artifacts/WordPress.app");
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), iosCapabilities);
            WebDriverWait iOSWait = new WebDriverWait(driver, 30);
        } else {
            System.out.println("Unable to set driver type");
        }
    }
}
