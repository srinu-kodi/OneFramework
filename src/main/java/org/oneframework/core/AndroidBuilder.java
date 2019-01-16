package org.oneframework.core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.oneframework.config.DeviceConfig;
import org.oneframework.utils.FileUtility;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

public class AndroidBuilder {

    AndroidDriver driver;

    public AndroidDriver setupDriver() throws IOException {
        DesiredCapabilities androidCapabilities = new DesiredCapabilities();
        androidCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceConfig.getAndroid().getDeviceName());
        androidCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, DeviceConfig.getAndroid().getPlatformName());
        androidCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, DeviceConfig.getAndroid().getPlatformVersion());
        androidCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, DeviceConfig.getAndroid().getAutomationName());
        androidCapabilities.setCapability(MobileCapabilityType.NO_RESET, DeviceConfig.getAndroid().isReset());
        androidCapabilities.setCapability(MobileCapabilityType.APP, FileUtility.getFile(DeviceConfig.getAndroid().getApp()).getAbsolutePath());
        androidCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, DeviceConfig.getAndroid().getPackageName());
        androidCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, DeviceConfig.getAndroid().getActivity());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), androidCapabilities);
        return driver;
    }
}
