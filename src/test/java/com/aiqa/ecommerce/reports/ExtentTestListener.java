package com.aiqa.ecommerce.reports;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aiqa.ecommerce.base.BaseTest;
import com.aiqa.ecommerce.utils.ScreenshotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentTestListener implements ITestListener {

    private static final ExtentReports REPORTS =
            ExtentReportManager.getInstance();

    private static final ThreadLocal<ExtentTest> CURRENT_TEST =
            new ThreadLocal<>();

    public static ExtentTest getCurrentTest() {
        return CURRENT_TEST.get();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = REPORTS.createTest(
                result.getTestClass().getName()
                        + " :: " + result.getMethod().getMethodName()
        );

        CURRENT_TEST.set(test);
        test.log(Status.INFO, "Test execution started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = CURRENT_TEST.get();

        if (test != null) {
            test.pass("Test passed successfully");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = CURRENT_TEST.get();

        if (test == null) {
            return;
        }

        test.fail("Test failed");

        if (result.getThrowable() != null) {
            test.fail(result.getThrowable());
        }

        Object instance = result.getInstance();

        if (instance instanceof BaseTest) {
            BaseTest baseTest = (BaseTest) instance;

            String screenshotPath = ScreenshotUtil.captureScreenshot(
                    baseTest.getDriverForReporting(),
                    result.getMethod().getMethodName()
            );

            if (screenshotPath != null
                    && new File(screenshotPath).isFile()) {
                try {
                    test.addScreenCaptureFromPath(screenshotPath);
                    test.info("Screenshot captured on test failure");
                } catch (Exception e) {
                    test.warning(
                            "Could not attach screenshot: "
                                    + e.getMessage()
                    );
                }
            } else {
                test.warning("Failure screenshot could not be captured");
            }
        } else {
            test.warning("Could not access BaseTest instance for screenshot");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = CURRENT_TEST.get();

        if (test != null) {
            test.skip("Test skipped");

            if (result.getThrowable() != null) {
                test.skip(result.getThrowable());
            }
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        REPORTS.flush();
        CURRENT_TEST.remove();
    }
}
