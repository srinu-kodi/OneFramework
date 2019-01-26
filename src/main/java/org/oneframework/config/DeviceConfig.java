package org.oneframework.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.oneframework.utils.FileUtility;

import java.io.IOException;

public class DeviceConfig {
    public static org.oneframework.config.IOSDeviceModel IOSDeviceModel;
    public static AndroidDeviceModel androidDeviceModel;
    public static String platformModelName;

    public static synchronized String getPlatformModelName() {
        return platformModelName;
    }

    public void setPlatformModelName(String platformModelName) {
        this.platformModelName = platformModelName;
    }

    public static IOSDeviceModel getIOSDevice(String model) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        IOSDeviceModel = objectMapper.readValue(FileUtils.getFile(FileUtility.getFile("iosDevice.json").getAbsolutePath()), IOSDeviceModel.class);
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
        if (model.equalsIgnoreCase(DeviceModel.NEXUS.toString())) {
            return androidDeviceModel.getNexus();
        } else if (model.equalsIgnoreCase(DeviceModel.PIXEL.toString())) {
            return androidDeviceModel.getPixel();
        } else {
            return null;
        }
    }
}
