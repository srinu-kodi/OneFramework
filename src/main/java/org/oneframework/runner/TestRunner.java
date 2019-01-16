package org.oneframework.runner;

import org.oneframework.imageCompare.ImageComparator;
import org.oneframework.utils.FileUtility;
import org.testng.TestNG;
import org.testng.collections.Lists;

import java.io.IOException;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) throws IOException {
        TestNG testng = new TestNG();

        if (args.length == 0) {
            System.out.println("Nothing is passed; Setting image capture to be true");
            ImageComparator.COMPARE = false;
        } else if (args[0].equalsIgnoreCase("compare")) {
            System.out.println("Setting image compare to be true");
            ImageComparator.COMPARE = true;
        } else if (args[0].equalsIgnoreCase("capture")) {
            System.out.println("Setting image capture to be true");
            ImageComparator.COMPARE = false;
        }
        List<String> suites = Lists.newArrayList();
        suites.add(FileUtility.getFile("testng.xml").getAbsolutePath());
        testng.setTestSuites(suites);
        testng.run();
    }
}
