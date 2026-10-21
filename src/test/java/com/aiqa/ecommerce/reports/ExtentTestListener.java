package com.aiqa.ecommerce.reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

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
        if (test != null) {
            test.fail("Test failed");
            if (result.getThrowable() != null) {
                test.fail(result.getThrowable());
            }
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

