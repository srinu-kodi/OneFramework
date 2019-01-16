package org.oneframework.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.oneframework.utils.FileUtility;

import java.io.IOException;

public class DeviceConfig {
    public static IosPojo iosPojo;
    public static AndroidPojo androidPojo;

    public static IosPojo getIOSDevice(String model) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        iosPojo = objectMapper.readValue(FileUtils.getFile(FileUtility.getFile("iosDevice.json").getAbsolutePath()), IosPojo.class);
        if (model.equalsIgnoreCase(DeviceModel.IPHONE6.toString())) {
            return iosPojo.getIphone6();
        } else if (model.equalsIgnoreCase(DeviceModel.IPHONE6S.toString())) {
            return iosPojo.getIphone6s();
        } else if (model.equalsIgnoreCase(DeviceModel.IPADAIR.toString())) {
            return iosPojo.getIpadAir();
        } else if (model.equalsIgnoreCase(DeviceModel.IPADAIR2.toString())) {
            return iosPojo.getIpadAir2();
        } else {
            return null;
        }
    }

    public static AndroidPojo getAndroidDevice(String model) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        androidPojo = objectMapper.readValue(FileUtils.getFile(FileUtility.getFile("androidDevice.json").getAbsolutePath()), AndroidPojo.class);
        if (model.equalsIgnoreCase(DeviceModel.NEXUS.toString())) {
            return androidPojo.getNexus();
        } else if (model.equalsIgnoreCase(DeviceModel.PIXEL.toString())) {
            return androidPojo.getPixel();
        } else {
            return null;
        }
    }
}
