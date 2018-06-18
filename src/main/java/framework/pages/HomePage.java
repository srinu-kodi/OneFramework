package framework.pages;

import framework.core.Page;
import framework.exceptionManager.LocatorNotSetException;

import java.util.HashMap;

public class HomePage extends Page {

    HashMap<String, HashMap> locatorMap = new HashMap<>();

    public HomePage() {
        System.out.println("Navigating to "+this.getClass().getSimpleName());
    }

    public HashMap<String, HashMap> eleLoginButton() {
        locatorMap.put("android", new HashMap(){{put("id", "login_button");}});
        locatorMap.put("ios", new HashMap(){{put("id", "Log In Button");}});
        return locatorMap;
    }

    public HashMap<String, HashMap> eleSignupButton() {
        locatorMap.put("android", new HashMap(){{put("id", "create_site_button");}});
        locatorMap.put("ios", new HashMap(){{put("id", "Sign up for WordPress.com Button");}});
        return locatorMap;
    }

    public LoginPage clickLoginButton() throws LocatorNotSetException {
        click(eleLoginButton());
        return new LoginPage();
    }

    public SignupPage clickSignupButton() throws LocatorNotSetException {
        click(eleSignupButton());
        return new SignupPage();
    }
}
