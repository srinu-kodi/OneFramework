package framework.core;

import framework.exceptionManager.LocatorNotSetException;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class Locator {

    static AppiumDriver driver;

    public Locator() {
        this.driver = new DriverManager().getDriver();
    }

    public WebElement getLocator(HashMap<String, HashMap> locatorMap) throws LocatorNotSetException {
        WebElement webElement = null;
        HashMap<String, String> map = locatorMap.get(DriverManager.driverType);
        for (String key : map.keySet()) {
            webElement = getLocatorByType(key, map.get(key));
        }
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    public WebElement getLocatorByType(String key, String value) throws LocatorNotSetException {
        WebElement we = null;
        switch (key) {
            case "id":
                we = driver.findElement(By.id(value));
                break;
            case "xpath":
                we = driver.findElement(By.xpath(value));
                break;
            case "className":
                we = driver.findElement(By.className(value));
                break;
            default:
                throw new LocatorNotSetException();
        }
        return we;
    }
}
