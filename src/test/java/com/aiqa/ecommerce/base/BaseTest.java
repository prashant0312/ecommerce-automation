package com.aiqa.ecommerce.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aiqa.ecommerce.utils.ScreenshotUtil;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected static final String BASE_URL =
            "https://www.demoblaze.com/";

    @BeforeMethod
    public void setUp() {

        ChromeOptions options = new ChromeOptions();

        // Enable headless Chrome on GitHub Actions.
        if ("true".equalsIgnoreCase(System.getenv("CI"))) {
            options.addArguments(
                    "--headless=new",
                    "--no-sandbox",
                    "--disable-dev-shm-usage",
                    "--window-size=1920,1080"
            );
        }

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        wait = new WebDriverWait(
                driver, Duration.ofSeconds(15));

        driver.get(BASE_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        try {
            if (result.getStatus() == ITestResult.FAILURE) {

                System.out.println(
                        "Test failed: " + result.getName());

                String screenshotPath =
                        ScreenshotUtil.captureScreenshot(
                                driver, result.getName());

                if (screenshotPath != null) {
                    System.out.println(
                            "Failure screenshot saved: "
                                    + screenshotPath);
                }

                if (result.getThrowable() != null) {
                    result.getThrowable().printStackTrace();
                }
            }
        } finally {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }
    }
}