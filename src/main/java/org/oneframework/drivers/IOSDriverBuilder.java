package org.oneframework.drivers;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.oneframework.config.DeviceConfig;
import org.oneframework.config.IosPojo;
import org.oneframework.utils.FileUtility;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

public class IOSDriverBuilder {

    IOSDriver driver;

    public IOSDriver setupDriver(String model) throws IOException {
        DesiredCapabilities iosCapabilities = new DesiredCapabilities();
        IosPojo device = DeviceConfig.getIOSDevice(model);

        iosCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device.getDeviceName());
        iosCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, device.getPlatformName());
        iosCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, device.getPlatformVersion());
        iosCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, device.getAutomationName());
        iosCapabilities.setCapability(MobileCapabilityType.UDID, device.getUdid());
        iosCapabilities.setCapability(MobileCapabilityType.NO_RESET, device.isReset());
        iosCapabilities.setCapability(MobileCapabilityType.APP, FileUtility.getFile(device.getApp()).getAbsolutePath());
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), iosCapabilities);
        return driver;
    }
}
