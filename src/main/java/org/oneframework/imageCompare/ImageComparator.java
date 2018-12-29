package org.oneframework.imageCompare;

import org.oneframework.pageHelpers.PageHelper;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageComparator extends PageHelper {
    WebDriver driver;
    public static boolean COMPARE = false;

    public boolean shouldCompare() {
        return COMPARE;
    }

    public void setCompare(boolean value) {
        this.COMPARE = value;
    }

    public ImageComparator(WebDriver driver) {
        this.driver = driver;
    }

//    private void createImageDirectory(String imagePath) {
//        String[] strArray = imagePath.split("/");
//        String directoryName = strArray[0];
//        new File(directoryName).mkdir();
//    }

//    private void copyImageFileIntoDirectory(String imagePath) throws IOException {
//        FileOutputStream fos = new FileOutputStream("./file.txt");
//        String[] strArray = imagePath.split("/");
//        //new File(strArray[0]).mkdir();
//        File srcFile = new File(strArray[1]);
//        File destinationDir = new File(strArray[0]);
//        FileUtils.copyFile(srcFile, destinationDir);
//    }

    public void capture(String imagePath) throws IOException, InterruptedException {
//        File directory = new File(imagePath.split("/")[0]);
//        File file = new File(imagePath.split("/")[1]);
//        if (!directory.exists()) {
//            directory.mkdir();
//        }
//        FileUtility.createDirectoryIfNotExist(directory);
//        FileUtility.copyFileToDirectory(file, directory);
        File imageFile = new File(imagePath + ".png");
        BufferedImage image = new AShot().takeScreenshot(driver).getImage();
        Thread.sleep(3000);
        ImageIO.write(image, "png", imageFile);
    }

//    public int compare(BufferedImage expectedImage, BufferedImage actualImage) throws IOException {
//        BufferedImage image = new AShot().takeScreenshot(driver).getImage();
//        ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);
//        BufferedImage diffImage = diff.getMarkedImage();
//        File outputDiffImage = new File("diffImage.png");
//        ImageIO.write(diffImage, "png", outputDiffImage);
//        return diff.getDiffSize();
//    }

    public boolean compare(String imageName) throws IOException, InterruptedException {
        boolean imageMatchFlag = false;
        if (!ImageComparator.COMPARE) {
            capture(imageName);
            imageMatchFlag = true;
        } else {
            File actualImageFile = new File(imageName + "_actual.png");
            Thread.sleep(3000);
            BufferedImage actualImage = new AShot().takeScreenshot(driver).getImage();
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
