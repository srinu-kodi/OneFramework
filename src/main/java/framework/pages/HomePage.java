package framework.pages;

import framework.core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage {

    WebDriver driver;
    public HomePage() {
        PageFactory.initElements(driver, HomePage.class);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
}
