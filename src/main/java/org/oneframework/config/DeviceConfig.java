package org.oneframework.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.oneframework.utils.FileUtility;

import java.io.IOException;

import static org.oneframework.logger.LoggingManager.logMessage;

public class DeviceConfig {
    public static IOSDeviceModel IOSDeviceModel;
    public static AndroidDeviceModel androidDeviceModel;
    public static String platformModelName;

    public static synchronized String getPlatformModelName() {
        return platformModelName;
    }

    public synchronized void setPlatformModelName(String platformModelName) {
        this.platformModelName = platformModelName;
    }

    public static IOSDeviceModel getIOSDevice(String model) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        IOSDeviceModel = objectMapper.readValue(FileUtils.getFile(FileUtility.getFile("iosDevice.json").getAbsolutePath()), IOSDeviceModel.class);
        logMessage("IOS device config file iosDevice.json has been parsed");
        if (model.equalsIgnoreCase(DeviceModel.IPHONE6.toString())) {
            return IOSDeviceModel.getIphone6();
        } else if (model.equalsIgnoreCase(DeviceModel.IPHONE6S.toString())) {
            return IOSDeviceModel.getIphone6s();
        } else if (model.equalsIgnoreCase(DeviceModel.IPADAIR.toString())) {
            return IOSDeviceModel.getIpadAir();
        } else if (model.equalsIgnoreCase(DeviceModel.IPADAIR2.toString())) {
            return IOSDeviceModel.getIpadAir2();
        } else {
            return null;
        }
    }

    public static AndroidDeviceModel getAndroidDevice(String model) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        androidDeviceModel = objectMapper.readValue(FileUtils.getFile(FileUtility.getFile("androidDevice.json").getAbsolutePath()), AndroidDeviceModel.class);
        logMessage("Android device config file androidDevice.json has been parsed");
        if (model.equalsIgnoreCase(DeviceModel.NEXUS.toString())) {
            return androidDeviceModel.getNexus();
        } else if (model.equalsIgnoreCase(DeviceModel.PIXEL.toString())) {
            return androidDeviceModel.getPixel();
        } else {
            return null;
        }
    }
}
