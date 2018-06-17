package framework.pages;

import framework.core.Page;

import java.util.HashMap;

public class LoginPage extends Page {
    HashMap<String, HashMap> locatorMap = new HashMap<>();

    public LoginPage() {
        System.out.println("Navigating to "+this.getClass().getSimpleName());
    }

    public HashMap<String, HashMap> elePageTitle() {
        locatorMap.put("android", new HashMap(){{put("id", "label");}});
        locatorMap.put("ios", new HashMap(){{put("id", "Log in to WordPress.com using an email address to manage all your WordPress sites.");}});
        return locatorMap;
    }

    public String getTitle() {
        return getText(elePageTitle());
    }
}
