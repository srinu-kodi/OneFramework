package org.oneframework.core;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.oneframework.utils.FileUtility;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

public class IPhoneBuilder {

    IOSDriver driver;

    public IOSDriver setupDriver() throws IOException {
        DesiredCapabilities iosCapabilities = new DesiredCapabilities();
        iosCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6s");
        iosCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        iosCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4");
        iosCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        iosCapabilities.setCapability(MobileCapabilityType.UDID, "B9072B66-ABFA-47C2-B0F7-55D40EF4D5F5");
        iosCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        iosCapabilities.setCapability(MobileCapabilityType.APP, FileUtility.getFile("WordPress.zip").getAbsolutePath());
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), iosCapabilities);
        //WebDriverWait iOSWait = new WebDriverWait(driver, 60);
        return driver;
    }
}
