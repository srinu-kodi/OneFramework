package framework.core;

import framework.pages.FlightSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App {
    public FlightSearchPage launch() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        return new FlightSearchPage();
    }
}
