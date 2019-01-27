package tests;

import org.oneframework.allureReport.TestListener;
import org.oneframework.imageCompare.ImageComparator;
import org.oneframework.pageObjects.HomePage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners({TestListener.class})
public class HomePageTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test(description = "testing the signin page visually")
    public void testSignInOption() throws Exception {
        HomePage homePage = new HomePage(driver);
        softAssert.assertTrue(new ImageComparator(driver).compare("homePage"), "homePage baseline image isn't matching with actual image.");
        homePage.chooseSignInOption();
        softAssert.assertTrue(new ImageComparator(driver).compare("signinPage"), "signinPage baseline image isn't matching with actual image.");
        softAssert.assertAll();
    }

    @Test(description = "testing the signup page visually")
    public void testSignUpOption() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.chooseSignUpOption();
        softAssert.assertTrue(new ImageComparator(driver).compare("signupPage"), "signupPage baseline image isn't matching with actual image.");
        softAssert.assertAll();
    }

}