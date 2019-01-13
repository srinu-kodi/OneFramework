package org.oneframework.core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.oneframework.utils.FileUtility;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

public class AndroidBuilder {

    AndroidDriver driver;

    public AndroidDriver setupDriver() throws IOException {
        DesiredCapabilities androidCapabilities = new DesiredCapabilities();
        androidCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        androidCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        androidCapabilities.setCapability(MobileCapabilityType.APP, FileUtility.getFile("WordPress.apk").getAbsolutePath());
        androidCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
        androidCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        androidCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.wordpress.android");
        androidCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        androidCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.wordpress.android.ui.WPLaunchActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), androidCapabilities);
        //WebDriverWait androidWait = new WebDriverWait(driver, 60);
        return driver;
    }
}
