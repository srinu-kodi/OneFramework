package org.oneframework.config;

public class AndroidPojo {
    private String deviceName;
    private String platformName;
    private String platformVersion;
    private String automationName;
    private String packageName;
    private String activity;
    private String app;
    private boolean reset;
    private AndroidPojo android;

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

    public AndroidPojo getAndroid() {
        return android;
    }

}
