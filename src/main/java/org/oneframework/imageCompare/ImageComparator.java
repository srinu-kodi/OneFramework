package org.oneframework.imageCompare;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.oneframework.config.DeviceConfig;
import org.oneframework.utils.FileUtility;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.CuttingDecorator;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.cutter.CutStrategy;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.oneframework.logger.LoggingManager.logMessage;

public class ImageComparator extends DeviceConfig {
    WebDriver driver;
    public static boolean COMPARE = false;
    public static String MODE;
    String baselineImageDirFullPath;

    public ImageComparator(WebDriver driver) {
        this.driver = driver;
        baselineImageDirFullPath = "baselineImages/" + getExecutionPlatform() + "/";
    }

    private BufferedImage getBaselineImage(String imageName) throws IOException {
        File expectedImageFile = FileUtils.getFile(FileUtility.getFile(baselineImageDirFullPath + imageName + ".png").getAbsolutePath());
        BufferedImage expectedImage = ImageIO.read(expectedImageFile);
        ImageIO.write(expectedImage, "png", expectedImageFile);
        logMessage("Retrieving the baseline image " + imageName + " from " + baselineImageDirFullPath);
        return expectedImage;
    }

    private BufferedImage captureActualImage(String imageName) throws IOException {
        File imageFile;
        if (ImageComparator.COMPARE) {
            imageFile = new File(imageName + "_actual.png");
        } else {
            imageFile = new File(imageName + ".png");
        }

        BufferedImage image = new AShot().takeScreenshot(driver).getImage();
        if (driver instanceof IOSDriver || driver instanceof AndroidDriver) {
            DeviceViewportModel viewport = DeviceConfig.readDeviceViewportConfig().getDeviceViewport(executionPlatform);
            image = image.getSubimage(viewport.getX(), viewport.getY(), viewport.getWidth(), viewport.getHeight());
        }
        ImageIO.write(image, "png", imageFile);
        FileUtility.copyFileToDirectory(imageFile, new File(baselineImageDirFullPath));
        logMessage("Capturing the image " + imageName + " into local baselineImages directory " + baselineImageDirFullPath);
        FileUtility.forceDelete(imageFile);
        return image;
    }

    public void createDiffImageAs(ImageDiff diffImg, String imageName) throws IOException {
        BufferedImage diffImage = diffImg.getMarkedImage();
        File diffImageFile = new File(imageName + "_diffImage.png");
        ImageIO.write(diffImage, "png", diffImageFile);
        FileUtility.copyFileToDirectory(diffImageFile, new File(baselineImageDirFullPath));
        logMessage("Saving the difference image into " + baselineImageDirFullPath);
        FileUtility.forceDelete(diffImageFile);
    }

    public boolean compare(String imageName) throws IOException {
        boolean imageMatchFlag = true;
        if (MODE.equalsIgnoreCase("visual")) {
            BufferedImage actualImage, expectedImage;
            ImageDiff diffImage;
            if (!ImageComparator.COMPARE) {
                captureActualImage(imageName);
            } else {
                expectedImage = getBaselineImage(imageName);
                actualImage = captureActualImage(imageName);
                diffImage = new ImageDiffer().makeDiff(expectedImage, actualImage);
                logMessage("Comparing the expected baseline image with actual image");
                if (diffImage.getDiffSize() > 0) {
                    createDiffImageAs(diffImage, imageName);
                    imageMatchFlag = false;
                } else {
                    imageMatchFlag = true;
                }
            }
        }
        return imageMatchFlag;
    }

}
