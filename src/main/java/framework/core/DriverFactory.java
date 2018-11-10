package framework.core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    static WebDriver driver;

    public static String driverType;
    public static String browsername = System.getProperty("browser");
    public static String os = System.getProperty("os.name");

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setupDriver() throws MalformedURLException {
        if (driverType.equals("android")) {
            DesiredCapabilities androidCapabilities = new DesiredCapabilities();
            androidCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            androidCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            androidCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/apps/WordPress.apk");
            androidCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
            androidCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
            androidCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.wordpress.android");
            androidCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            androidCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.wordpress.android.ui.WPLaunchActivity");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), androidCapabilities);
            WebDriverWait androidWait = new WebDriverWait(driver, 30);
        } else if (driverType.equals("ios")) {
            DesiredCapabilities iosCapabilities = new DesiredCapabilities();
            iosCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6s");
            iosCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
            iosCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4");
            iosCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            iosCapabilities.setCapability(MobileCapabilityType.UDID, "B9072B66-ABFA-47C2-B0F7-55D40EF4D5F5");
            iosCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            iosCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/apps/WordPress.app");
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), iosCapabilities);
            WebDriverWait iOSWait = new WebDriverWait(driver, 30);
        } else if (driverType.equalsIgnoreCase("web") && browsername.equalsIgnoreCase("chrome")) {
            if (os.contains("mac")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/browserDrivers/chromedriver_mac");
            } else if (os.contains("windows")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/browserDrivers/chromedriver_windows");
            } else if (os.contains("unix")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/browserDrivers/chromedriver_linux");
            }
            driver = new ChromeDriver();
            driver.get("https://wordpress.com/");
        } else {
            System.out.println("Either platform or browser type is not set, please pass thru command line");
        }
    }
}