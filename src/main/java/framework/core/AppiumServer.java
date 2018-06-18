package framework.core;

import framework.exceptionManager.AppiumException;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.IOException;

public class AppiumServer {

    static AppiumDriverLocalService appium;

    public static void start() throws IOException {
        try {
            AppiumServiceBuilder builder = new AppiumServiceBuilder().withArgument(GeneralServerFlag.SESSION_OVERRIDE);
            appium = builder.build();
            appium.start();
            if (appium != null) {
                System.out.println("Appium server is started now");
            } else {
                throw new AppiumException();
            }
        } catch (AppiumException ex) {
            ex.printStackTrace();
        }
    }

    public static void stop() throws IOException {
        try {
            if (appium == null) {
                throw new AppiumException();
            }
            else {
                appium.stop();
                System.out.println("Appium server is stopped now");
            }
        } catch (AppiumException ex) {
            ex.printStackTrace();
        }

    }
}
