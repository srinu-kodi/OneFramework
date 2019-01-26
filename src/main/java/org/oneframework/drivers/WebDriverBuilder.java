package org.oneframework.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.oneframework.config.DeviceConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.net.MalformedURLException;

public class WebDriverBuilder extends DeviceConfig {

    WebDriver driver;

    public WebDriver setupDriver(String platformName) throws MalformedURLException {
        if (platformName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            setPlatformModelName("chrome");
        } else if (platformName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            setPlatformModelName("firefox");
        } else if (platformName.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            setPlatformModelName("ie");
        } else if (platformName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            setPlatformModelName("edge");
        } else if (platformName.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
            setPlatformModelName("opera");
        }
        return driver;
    }

}
