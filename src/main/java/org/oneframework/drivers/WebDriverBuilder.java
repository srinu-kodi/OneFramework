package org.oneframework.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.oneframework.config.DeviceConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.IOException;

import static org.oneframework.logger.LoggingManager.logMessage;

public class WebDriverBuilder extends DeviceConfig {

    WebDriver driver;

    public WebDriver setupDriver(String platformName) throws IOException {
        if (platformName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            logMessage(platformName + " driver has been created for the execution");
            setPlatformModelName("chrome");
        } else if (platformName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            logMessage(platformName + " driver has been created for the execution");
            setPlatformModelName("firefox");
        } else if (platformName.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            logMessage(platformName + " driver has been created for the execution");
            setPlatformModelName("ie");
        } else if (platformName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            logMessage(platformName + " driver has been created for the execution");
            setPlatformModelName("edge");
        } else if (platformName.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
            logMessage(platformName + " driver has been created for the execution");
            setPlatformModelName("opera");
        }
        return driver;
    }

}
