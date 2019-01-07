package tests;

import org.oneframework.allureReporting.TestListener;
import org.oneframework.imageCompare.ImageComparator;
import org.oneframework.pageObjects.HomePage;
import org.testng.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class HomePageTest extends BaseTest {

    @Test(description = "testing the signin page visually")
    public void testSignInOption() throws Exception {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(new ImageComparator(driver).compare("homePage"), "homePage baseline image isn't matching with actual image.");
        homePage.chooseSignInOption();
        Assert.assertTrue(new ImageComparator(driver).compare("signinPage"), "signinPage baseline image isn't matching with actual image.");
    }

    @Test(description = "testing the signup page visually")
    public void testSignUpOption() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.chooseSignUpOption();
        Assert.assertTrue(new ImageComparator(driver).compare("signupPage"), "signupPage baseline image isn't matching with actual image.");
    }

}