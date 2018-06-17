package framework.core;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.IOException;

public class AppiumServer {

    static AppiumDriverLocalService appium;

    public static void start() throws IOException {
        AppiumServiceBuilder builder = new AppiumServiceBuilder().withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        appium = builder.build();
        appium.start();
        System.out.println("Appium server is started now");
    }

    public static void stop() throws IOException{
        appium.stop();
        System.out.println("Appium server is stopped now");
    }
}
