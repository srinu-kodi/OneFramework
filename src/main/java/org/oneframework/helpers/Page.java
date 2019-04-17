package org.oneframework.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {

    WebDriver driver;

    public void clickElement(WebElement element) {
        element.click();
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public void enterText(WebElement element, String value) {
        element.sendKeys(value);
    }

}
