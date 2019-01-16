package org.oneframework.pageObjects;

import org.oneframework.helpers.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class SignInPage extends Page {

    WebDriver driver;
    HashMap<String, HashMap> elePageTitle = new HashMap<>();
    HashMap<String, HashMap> eleSignInTitle = new HashMap<>();

    public SignInPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elePageTitle.put("android", new HashMap(){{put("id", "label");}});
        elePageTitle.put("ios", new HashMap(){{put("id", "Log in to WordPress.com using an email address to manage all your WordPress sites.");}});
        elePageTitle.put("web", new HashMap(){{put("xpath", "//div[@class='login__form-header']");}});

        eleSignInTitle.put("web", new HashMap(){{put("xpath", "//div[contains(text(), 'Log in to')]");}});
        eleSignInTitle.put("ios", new HashMap(){{put("xpath", "//XCUIElementTypeStaticText[contains(@label, 'Log in to WordPress.com using an email address to manage all your WordPress sites.')]");}});
        eleSignInTitle.put("android", new HashMap(){{put("id", "label");}});
        Thread.sleep(1000);
    }

    public String getTitle() throws Exception {
        return getText(driver, elePageTitle);
    }

    public void clickOnSignInTitle() throws Exception {
        clickElement(driver,eleSignInTitle);
    }
}
