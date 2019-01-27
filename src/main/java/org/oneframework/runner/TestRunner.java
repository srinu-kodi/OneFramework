package org.oneframework.runner;

import org.oneframework.imageCompare.ImageComparator;
import org.oneframework.utils.FileUtility;
import org.testng.TestNG;
import org.testng.collections.Lists;

import java.io.IOException;
import java.util.List;

import static org.oneframework.logger.LoggingManager.logMessage;

public class TestRunner {
    public static void main(String[] args) throws IOException {
        TestNG testng = new TestNG();

        if (args.length == 0) {
            logMessage("Image Comparison arguments not passed; Capture is enabled by default");
        } else if (args[0].equalsIgnoreCase("compare")) {
            logMessage("Setting image compare as TRUE");
            ImageComparator.COMPARE = true;
        } else if (args[0].equalsIgnoreCase("capture")) {
            logMessage("Setting image capture as TRUE");
            ImageComparator.COMPARE = false;
        }
        List<String> suites = Lists.newArrayList();
        suites.add(FileUtility.getFile("testng.xml").getAbsolutePath());
        testng.setTestSuites(suites);
        testng.run();
    }
}
