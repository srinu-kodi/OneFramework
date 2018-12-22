package org.oneframework.pageHelpers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class PageHelper {

    WebDriver driver;

    public void clickElement(WebDriver driver, HashMap<String, HashMap> locatorHashMap) throws Exception {
        this.driver = driver;
        if (driver instanceof AndroidDriver) {
            getElement("android", locatorHashMap.get("android")).click();
        } else if (driver instanceof IOSDriver) {
            getElement("ios", locatorHashMap.get("ios")).click();
        } else if (driver instanceof FirefoxDriver || driver instanceof ChromeDriver) {
            getElement("web", locatorHashMap.get("web")).click();
        }
    }

    public String getText(WebDriver driver, HashMap<String, HashMap> locatorHashMap) throws Exception {
        String text = "";
        if (driver instanceof AndroidDriver) {
            text = getElement("android", locatorHashMap.get("android")).getText();
        } else if (driver instanceof IOSDriver) {
            text = getElement("ios", locatorHashMap.get("ios")).getText();
        } else if (driver instanceof FirefoxDriver || driver instanceof ChromeDriver) {
            text = getElement("web", locatorHashMap.get("web")).getText();
        }
        return text;
    }

    public WebElement getElement(String platform, HashMap<String, String> locatorMap) throws Exception {
        WebElement webElement = null;
        for (String key : locatorMap.keySet()) {
            webElement = (WebElement) getElementByType(key, locatorMap.get(key));
            break;
        }
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    public WebElement getElementByType(String key, String value) throws Exception {
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
                throw new Exception();
        }
        return we;
    }

}
