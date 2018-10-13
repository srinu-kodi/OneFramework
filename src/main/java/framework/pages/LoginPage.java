package framework.pages;

import framework.core.Page;
import framework.exceptionManager.LocatorNotSetException;

import java.util.HashMap;

public class LoginPage extends Page {
    HashMap<String, HashMap> elePageTitle = new HashMap<>();

    public LoginPage() {
        elePageTitle.put("android", new HashMap(){{put("id", "label");}});
        elePageTitle.put("ios", new HashMap(){{put("id", "Log in to WordPress.com using an email address to manage all your WordPress sites.");}});
        elePageTitle.put("web", new HashMap(){{put("xpath", "//div[@class='login__form-header']");}});
    }

    public String getTitle() throws LocatorNotSetException {
        return getText(elePageTitle);
    }
}
