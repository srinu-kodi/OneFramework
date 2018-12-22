package tests;

import org.oneframework.pageObjects.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(description = "testing the signin button feature")
    public void testSignInOption() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.chooseSignInOption();
    }

    @Test(description = "testing the signup button feature")
    public void testSignUpOption() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.chooseSignUpOption();
    }
}