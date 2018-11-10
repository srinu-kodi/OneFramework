package stepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import framework.core.AppiumServer;
import framework.core.DriverFactory;

import java.io.IOException;

public class Hooks {

    @Before()
    public void beforeTestsRun() throws IOException {
        DriverFactory.driverType = System.getProperty("platform"); // Getting the platform name from gradle commandline and setting this value in build.gradle
        if (DriverFactory.driverType.equals("web")) {
            DriverFactory.setupDriver();
        } else if (DriverFactory.driverType.equals("android") || DriverFactory.driverType.equals("ios")) {
            AppiumServer.start();
            DriverFactory.setupDriver();
        } else {
            System.out.println("Please specify the platform type");
        }
    }

    @After()
    public void afterTestsRun() throws IOException {
        if (DriverFactory.driverType.equals("web")) {
            DriverFactory.getDriver().quit();
        } else if (DriverFactory.driverType.equals("android") || DriverFactory.driverType.equals("ios")) {
            DriverFactory.getDriver().quit();
            AppiumServer.stop();
        } else {
            System.out.println("Driver/Appium instance is already shutdown");
        }
    }
}