package framework.core;

public class DriverConfig {
    public static final String ANDROID_EMULATOR_NAME = "emulator-5554";
    public static final String ANDROID_PLATFORM_NAME = "Android";
    public static final String ANDROID_APP_PATH = "/artifacts/WordPress.apk";
    public static final String ANDROID_PACKAGE_NAME = "org.wordpress.android";
    public static final String ANDROID_ACTIVITY_NAME = "org.wordpress.android.ui.WPLaunchActivity";
    public static final boolean ANDROID_APP_NO_RESET = true;

    public static final String IOS_SIMULATOR_NAME = "iPhone 8";
    public static final String IOS_PLATFORM_NAME = "iOS";
    public static final String IOS_PLATFORM_VERSION = "11.4";
    public static final String IOS_APP_PATH = "/artifacts/WordPress.app";
    public static final String IOS_SIMULATOR_UDID = "65D41497-6506-41C3-9644-EC166EEA2159";
    public static final String IOS_AUTOMATION_NAME = "XCUITest";
    public static final boolean IOS_APP_NO_RESET = true;

    public static final String CHROME_DRIVER_PATH_MAC = "/dependency/chromedriver_mac";
    public static final String CHROME_DRIVER_PATH_WINDOWS = "/dependency/chromedriver_windows.exe";
    public static final String CHROME_DRIVER_PATH_LINUX = "/dependency/chromedriver_linux";
    public static final String APP_URL = "https://wordpress.com/";
}