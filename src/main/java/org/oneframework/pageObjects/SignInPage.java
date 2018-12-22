package org.oneframework.pageObjects;

import org.oneframework.pageHelpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class SignInPage extends PageHelper {

    WebDriver driver;
    HashMap<String, HashMap> elePageTitle = new HashMap<>();

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elePageTitle.put("android", new HashMap(){{put("id", "label");}});
        elePageTitle.put("ios", new HashMap(){{put("id", "Log in to WordPress.com using an email address to manage all your WordPress sites.");}});
        elePageTitle.put("web", new HashMap(){{put("xpath", "//div[@class='login__form-header']");}});
    }

    public String getTitle() throws Exception {
        return getText(driver, elePageTitle);
    }
}
