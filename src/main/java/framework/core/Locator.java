package framework.core;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.HashMap;

public class Locator {

    AppiumDriver driver;

    public Locator(AppiumDriver driver) {
        this.driver = new DriverManager().getDriver();
    }

    public WebElement getLocator(HashMap<String, HashMap> locatorMap) {
        WebElement webElement = null;
        HashMap<String, String> map = locatorMap.get(DriverManager.driverType);
        for (String key : map.keySet()) {
             webElement = getLocatorByType(key, map.get(key));
        }
        return webElement;
    }

    public WebElement getLocatorByType(String key, String value) {
        WebElement we = null;
        switch (key) {
            case "id":
                we = driver.findElement(By.id(value));
                break;
            case "xpath":
                we = driver.findElement(By.xpath(value));
                break;
        }
        return we;
    }
}
