package org.oneframework.core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.oneframework.config.AndroidPojo;
import org.oneframework.config.DeviceConfig;
import org.oneframework.config.IosPojo;
import org.oneframework.utils.FileUtility;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

public class AndroidBuilder {

    AndroidDriver driver;

    public AndroidDriver setupDriver(String model) throws IOException {
        DesiredCapabilities androidCapabilities = new DesiredCapabilities();
        AndroidPojo device = DeviceConfig.getAndroidDevice(model);

        androidCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device.getDeviceName());
        androidCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, device.getPlatformName());
        androidCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, device.getPlatformVersion());
        androidCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, device.getAutomationName());
        androidCapabilities.setCapability(MobileCapabilityType.NO_RESET, device.isReset());
        androidCapabilities.setCapability(MobileCapabilityType.APP, FileUtility.getFile(device.getApp()).getAbsolutePath());
        androidCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, device.getPackageName());
        androidCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, device.getActivity());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), androidCapabilities);
        return driver;
    }
}
