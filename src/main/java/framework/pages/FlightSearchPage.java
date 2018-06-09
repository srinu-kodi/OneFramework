package framework.pages;

import framework.core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlightSearchPage {

    public FlightSearchPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), FlightSearchPage.class);
        DriverManager.getWebDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

}
