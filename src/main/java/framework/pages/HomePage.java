package framework.pages;

import framework.core.PageActions;
import io.appium.java_client.AppiumDriver;

import java.util.HashMap;

public class HomePage extends PageActions {
    static AppiumDriver driver;
    HashMap<String, HashMap> locatorMap = new HashMap<>();

    public HomePage() {
        super(driver);
    }

    public HashMap<String, HashMap> eleLoginButton() {
        locatorMap.put("android", new HashMap(){{put("id", "login_button");}});
        locatorMap.put("ios", new HashMap(){{put("xpath", "ios_login_button");}});
        return locatorMap;
    }

    public HashMap<String, HashMap> eleSignupButton() {
        locatorMap.put("android", new HashMap(){{put("id", "create_site_button");}});
        locatorMap.put("ios", new HashMap(){{put("xpath", "ios_create_site_button");}});
        return locatorMap;
    }

    public LoginPage clickLoginButton() {
        click(eleLoginButton());
        return new LoginPage();
    }

    public SignupPage clickSignupButton() {
        click(eleSignupButton());
        return new SignupPage();
    }
}
