package org.oneframework.imageCompare;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.oneframework.config.DeviceConfig;
import org.oneframework.utils.FileUtility;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.oneframework.logger.LoggingManager.logMessage;

public class ImageComparator extends DeviceConfig {
    WebDriver driver;
    public static boolean COMPARE = false;
    String baselineImageDirFullPath = "baselineImages/" + getPlatformModelName() + "/";

    public ImageComparator(WebDriver driver) {
        this.driver = driver;
    }

    public void capture(String imageName) throws IOException {
        File imageFile = new File(imageName + ".png");
        BufferedImage image = new AShot().takeScreenshot(driver).getImage();
        if (driver instanceof IOSDriver) {
            image = image.getSubimage(0, 48, 740, 1280);
        } else if (driver instanceof AndroidDriver) {
            image = image.getSubimage(0, 64, 1080, 1728);
        }
        ImageIO.write(image, "png", imageFile);
        FileUtility.copyFileToDirectory(imageFile, new File(baselineImageDirFullPath));
        logMessage("Capturing the baseline image " + imageName + " into local baselineImages directory " + baselineImageDirFullPath);
        FileUtility.forceDelete(imageFile);
    }

    public boolean compare(String imageName) throws IOException {
        boolean imageMatchFlag = false;
        if (!ImageComparator.COMPARE) {
            capture(imageName);
            imageMatchFlag = true;
        } else {
            File actualImageFile = new File(imageName + "_actual.png");
            BufferedImage actualImage = new AShot().takeScreenshot(driver).getImage();
            if (driver instanceof IOSDriver) {
                actualImage = actualImage.getSubimage(0, 48, 740, 1280);
            } else if (driver instanceof AndroidDriver) {
                actualImage = actualImage.getSubimage(0, 64, 1080, 1728);
            }
            ImageIO.write(actualImage, "png", actualImageFile);
            FileUtility.copyFileToDirectory(actualImageFile, new File(baselineImageDirFullPath));
            logMessage("Capturing the actual image " + imageName + " into local baselineImages directory " + baselineImageDirFullPath);
            FileUtility.forceDelete(actualImageFile);

            File expectedImageFile = FileUtils.getFile(FileUtility.getFile(baselineImageDirFullPath + imageName + ".png").getAbsolutePath());
            BufferedImage expectedImage = ImageIO.read(expectedImageFile);
            ImageIO.write(expectedImage, "png", expectedImageFile);
            logMessage("Reading the baseline image " + imageName + " from " + baselineImageDirFullPath);
            ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);
            logMessage("Comparing the expected baseline image with actual image");

            if (diff.getDiffSize() > 0) {
                BufferedImage diffImage = diff.getMarkedImage();
                File diffImageFile = new File(imageName + "_diffImage.png");
                ImageIO.write(diffImage, "png", diffImageFile);
                FileUtility.copyFileToDirectory(diffImageFile, new File(baselineImageDirFullPath));
                logMessage("Saving the difference image into " + baselineImageDirFullPath);
                FileUtility.forceDelete(diffImageFile);
            } else {
                imageMatchFlag = true;
            }
        }
        return imageMatchFlag;
    }

}
