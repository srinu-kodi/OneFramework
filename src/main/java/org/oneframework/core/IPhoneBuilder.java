package org.oneframework.core;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.oneframework.config.DeviceConfig;
import org.oneframework.utils.FileUtility;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

public class IPhoneBuilder {

    IOSDriver driver;

    public IOSDriver setupDriver() throws IOException {
        DesiredCapabilities iosCapabilities = new DesiredCapabilities();
        iosCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceConfig.getIPhone().getDeviceName());
        iosCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, DeviceConfig.getIPhone().getPlatformName());
        iosCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, DeviceConfig.getIPhone().getPlatformVersion());
        iosCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, DeviceConfig.getIPhone().getAutomationName());
        iosCapabilities.setCapability(MobileCapabilityType.UDID, DeviceConfig.getIPhone().getUdid());
        iosCapabilities.setCapability(MobileCapabilityType.NO_RESET, DeviceConfig.getIPhone().isReset());
        iosCapabilities.setCapability(MobileCapabilityType.APP, FileUtility.getFile(DeviceConfig.getIPhone().getApp()).getAbsolutePath());
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), iosCapabilities);
        return driver;
    }
}
