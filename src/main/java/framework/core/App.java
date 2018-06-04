package framework.core;

import framework.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App {
    public HomePage launch() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        return new HomePage();
    }
}
