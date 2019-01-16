package org.oneframework.allureReport;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

public class TestListener extends BaseTest implements ITestListener {

    private static String getMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getMethodName();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("TEST START: "+iTestResult.getMethod().getMethodName()+" - "+iTestResult.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("TEST PASS: "+iTestResult.getMethod().getMethodName()+" - "+iTestResult.getMethod().getDescription());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("TEST FAIL: "+iTestResult.getMethod().getMethodName()+" - "+iTestResult.getMethod().getDescription());
        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest)testClass).driver;
        saveScreenshot(driver, iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("TEST SKIP: "+iTestResult.getMethod().getMethodName()+" - "+iTestResult.getMethod().getDescription());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("TEST FAIL WITH BUSINESS REQ: "+iTestResult.getMethod().getMethodName()+" - "+iTestResult.getMethod().getDescription());
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("TEST FINISH: "+context.getName());
    }

    @Attachment(value = "Actual Screenshot", type = "image/png")
    public void saveScreenshot(WebDriver driver, ITestResult iTestResult) {
        ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
