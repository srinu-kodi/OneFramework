package framework.core;

import framework.exceptionManager.LocatorNotSetException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class Page extends Locator {

    public Page() {

    }

    public void click(HashMap<String, HashMap> locatorMap) throws LocatorNotSetException {
        getLocator(locatorMap).click();
    }

    public void sendKeys(HashMap<String, HashMap> locatorMap, String value) throws LocatorNotSetException {
        getLocator(locatorMap).sendKeys(value);
    }

    public String getText(HashMap<String, HashMap> locatorMap) throws LocatorNotSetException {
        return getLocator(locatorMap).getText();
    }

    public boolean isElementPresent(HashMap<String, HashMap> locatorMap) throws LocatorNotSetException {
        return isElementDisplayed(locatorMap);
    }
}
