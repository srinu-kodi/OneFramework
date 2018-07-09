package stepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import framework.core.AppiumServer;
import framework.core.DriverManager;
import java.io.IOException;

public class Hooks {

    @Before
    public void beforeClass() {
        System.out.println("Initializing the driver instance");
    }

    @Before()
    public void beforeTestsRun() throws IOException {
        DriverManager.driverType = System.getProperty("platform");
        if (DriverManager.driverType.equals("web")) {
            DriverManager.startAUT();
        } else if (DriverManager.driverType.equals("android") || DriverManager.driverType.equals("ios")) {
            AppiumServer.start();
            DriverManager.startAUT();
        } else {
            System.out.println("Please specify the platform type");
        }
    }

    @After()
    public void afterTestsRun() throws IOException {
        if (DriverManager.driverType.equals("web")) {
            DriverManager.getDriver().quit();
        } else if (DriverManager.driverType.equals("android") || DriverManager.driverType.equals("ios")) {
            DriverManager.getDriver().quit();
            AppiumServer.stop();
        } else {
            System.out.println("Driver/Appium instance is already shutdown");
        }
    }
}