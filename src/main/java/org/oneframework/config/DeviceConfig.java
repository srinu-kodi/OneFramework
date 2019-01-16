package org.oneframework.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DeviceConfig {
    public static IPhonePojo iphonePojo;
    public static IPadPojo ipadPojo;
    public static AndroidPojo androidPojo;

    public static IPhonePojo getIPhone() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        iphonePojo = objectMapper.readValue(new File("/Users/srinuk/Documents/Srinu/Playground/OneFramework/src/main/java/org/oneframework/config/iphoneDriver.json"), IPhonePojo.class);
        return iphonePojo.getIphone();
    }

    public static IPadPojo getIPad() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ipadPojo = objectMapper.readValue(new File("/Users/srinuk/Documents/Srinu/Playground/OneFramework/src/main/java/org/oneframework/config/ipadDriver.json"), IPadPojo.class);
        return ipadPojo.getIpad();
    }

    public static AndroidPojo getAndroid() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        androidPojo = objectMapper.readValue(new File("/Users/srinuk/Documents/Srinu/Playground/OneFramework/src/main/java/org/oneframework/config/androidDriver.json"), AndroidPojo.class);
        return androidPojo.getAndroid();
    }
}
