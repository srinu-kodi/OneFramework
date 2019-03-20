package org.oneframework.config;

import java.util.Arrays;

public class AndroidDeviceModel {
    private String deviceName;
    private String platformName;
    private String platformVersion;
    private String automationName;
    private String packageName;
    private String activity;
    private String app;
    private String name;
    private boolean reset;
    private AndroidDeviceModel[] androidDeviceModels;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AndroidDeviceModel(AndroidDeviceModel[] androidDeviceModels) {
        this.androidDeviceModels = androidDeviceModels;
    }

    public AndroidDeviceModel() {}

    public AndroidDeviceModel getAndroidDeviceByName(String deviceName) {
        return Arrays.stream(androidDeviceModels).filter(androidDeviceModel -> androidDeviceModel.getName().equalsIgnoreCase(deviceName)).findFirst().get();
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public void setAutomationName(String automationName) {
        this.automationName = automationName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public void setReset(boolean reset) {
        this.reset = reset;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getPlatformName() {
        return platformName;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public String getAutomationName() {
        return automationName;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getActivity() {
        return activity;
    }

    public String getApp() {
        return app;
    }

    public boolean isReset() {
        return reset;
    }

}
