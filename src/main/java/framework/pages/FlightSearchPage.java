package framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class FlightSearchPage {

    WebDriver driver;
    public FlightSearchPage() {
        PageFactory.initElements(driver, FlightSearchPage.class);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
}
