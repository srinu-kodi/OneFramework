package tests;

import org.oneframework.imageCompare.ImageComparator;
import org.oneframework.pageObjects.HomePage;
import org.oneframework.utils.FileUtility;
import org.testng.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

public class HomePageTest extends BaseTest {

    @Test(description = "testing the signin feature")
    public void testSignInOption() throws Exception {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(new ImageComparator(driver).compare("homePage"));
    }

    @Test(description = "testing the signup feature")
    public void testSignUpOption() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.chooseSignUpOption();
        Assert.assertTrue(new ImageComparator(driver).compare("signupPage"));
    }
}