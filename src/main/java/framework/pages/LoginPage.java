package framework.pages;

import framework.core.Page;
import framework.exceptionManager.LocatorNotSetException;

import java.util.HashMap;

public class LoginPage extends Page {
    HashMap<String, HashMap> locatorMap = new HashMap<>();

    public LoginPage() {
        System.out.println("Navigating to "+this.getClass().getSimpleName());
    }

    private HashMap<String, HashMap> elePageTitle() {
        locatorMap.put("android", new HashMap(){{put("id", "label");}});
        locatorMap.put("ios", new HashMap(){{put("id", "Log in to WordPress.com using an email address to manage all your WordPress sites.");}});
        locatorMap.put("web", new HashMap(){{put("xpath", "//div[@class='login__form-header']");}});
        return locatorMap;
    }

    public String getTitle() throws LocatorNotSetException {
        return getText(elePageTitle());
    }
}
