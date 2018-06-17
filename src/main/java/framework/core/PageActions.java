package framework.core;

import java.util.HashMap;

public class PageActions extends Locator {

    public PageActions() {
        super(driver);
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
