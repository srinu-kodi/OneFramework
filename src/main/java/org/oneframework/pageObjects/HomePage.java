package org.oneframework.pageObjects;

import org.oneframework.helpers.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class HomePage extends Page {

    WebDriver driver;

    HashMap<String, HashMap> eleSignInBtn = new HashMap<>();
    HashMap<String, HashMap> eleSignUpBtn = new HashMap<>();


    public HomePage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        eleSignInBtn.put("android", new HashMap(){{put("id", "login_button");}});
        eleSignInBtn.put("ios", new HashMap(){{put("xpath", "//XCUIElementTypeButton[contains(@label, 'Log In')]");}});
        eleSignInBtn.put("web", new HashMap(){{put("xpath", "//a[@title='Log In'][1]");}});

        eleSignUpBtn.put("android", new HashMap(){{put("id", "create_site_button");}});
        eleSignUpBtn.put("ios", new HashMap(){{put("id", "Sign up for WordPress.com Button");}});
        eleSignUpBtn.put("web", new HashMap(){{put("xpath", "//a[@title='Get Started']");}});
        Thread.sleep(1000);
    }

    public SignInPage chooseSignInOption() throws Exception {
        clickElement(driver,eleSignInBtn);
        new SignInPage(driver).clickOnSignInTitle();
        return new SignInPage(driver);
    }

    public SignUpPage chooseSignUpOption() throws Exception {
        clickElement(driver,eleSignUpBtn);
        return new SignUpPage(driver);
    }

}