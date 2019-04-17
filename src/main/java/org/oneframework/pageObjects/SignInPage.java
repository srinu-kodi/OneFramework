package org.oneframework.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.oneframework.helpers.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.oneframework.logger.LoggingManager.logMessage;

public class SignInPage extends Page {

    @FindBy(xpath = "//div[@class='login__form-header']")
    @AndroidFindBy(id = "label")
    @iOSFindBy(id = "Log in to WordPress.com using an email address to manage all your WordPress sites.")
    private WebElement elePageTitle;

    @FindBy(xpath = "//div[contains(text(), 'Log in to')]")
    @AndroidFindBy(id = "label")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@label, 'Log in to WordPress.com using an email address to manage all your WordPress sites.')]")
    private WebElement eleSignInTitle;


    WebDriver driver;

    public SignInPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logMessage("Initializing the " + this.getClass().getSimpleName() + " elements");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Thread.sleep(1000);
    }

    public String getTitle() throws Exception {
        return getText(elePageTitle);
    }

    public void clickOnSignInTitle() throws Exception {
        clickElement(eleSignInTitle);
    }
}
