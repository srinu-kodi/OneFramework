package framework.core;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class Page extends Locator {

    public Page() {

    }

    public void click(HashMap<String, HashMap> locatorMap) {
        getLocator(locatorMap).click();
    }

    public void sendKeys(HashMap<String, HashMap> locatorMap, String value) {
        getLocator(locatorMap).sendKeys(value);
    }

    public String getText(HashMap<String, HashMap> locatorMap) {
        return getLocator(locatorMap).getText();
    }
}
