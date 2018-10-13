package framework.core;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.io.IOException;

public class AppiumServer {

    static AppiumDriverLocalService appium;

    public static void start() throws IOException {
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withLogFile(new File(System.getProperty("user.dir") + "/appiumServerLog.txt"));
        appium = builder.build();
        System.out.println("Starting the Appium Server on 127.0.0.1:4723");
        appium.start();
    }

    public static void stop() {
        System.out.println("Stopping the Appium Server");
        appium.stop();
    }
}
