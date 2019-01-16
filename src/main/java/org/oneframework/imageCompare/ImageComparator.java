package org.oneframework.imageCompare;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.oneframework.helpers.Page;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageComparator extends Page {
    WebDriver driver;
    public static boolean COMPARE = false;

    public ImageComparator(WebDriver driver) {
        this.driver = driver;
    }

    public void capture(String imageName) throws IOException, InterruptedException {
        File imageFile = new File(imageName + ".png");
        BufferedImage image = new AShot().takeScreenshot(driver).getImage();
        if (driver instanceof IOSDriver) {
            image = image.getSubimage(0, 48, 740, 1280);
        } else if (driver instanceof AndroidDriver) {
            image = image.getSubimage(0, 64, 1080, 1728);
        }
        ImageIO.write(image, "png", imageFile);
    }

    public boolean compare(String imageName) throws IOException, InterruptedException {
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

            File expectedImageFile = new File(imageName + ".png");
            BufferedImage expectedImage = ImageIO.read(expectedImageFile);
            ImageIO.write(expectedImage, "png", expectedImageFile);
            ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

            if (diff.getDiffSize() > 0) {
                BufferedImage diffImage = diff.getMarkedImage();
                File outputDiffImage = new File(imageName + "_diffImage.png");
                ImageIO.write(diffImage, "png", outputDiffImage);
                imageMatchFlag = false;
            } else {
                imageMatchFlag = true;
            }
        }
        return imageMatchFlag;
    }

}
