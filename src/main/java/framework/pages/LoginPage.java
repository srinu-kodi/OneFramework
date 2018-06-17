package framework.pages;

import framework.core.PageActions;

import java.util.HashMap;

public class LoginPage extends PageActions{
    HashMap<String, HashMap> locatorMap = new HashMap<>();

    public LoginPage() {
        System.out.println("Navigating to "+this.getClass().getSimpleName());
    }

    public HashMap<String, HashMap> elePageTitle() {
        locatorMap.put("android", new HashMap(){{put("id", "label");}});
        locatorMap.put("ios", new HashMap(){{put("id", "label");}});
        return locatorMap;
    }

    public String getTitle() {
        return getText(elePageTitle());
    }
}
