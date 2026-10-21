package com.aiqa.ecommerce.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    private static final String SCREENSHOT_DIR = "target/screenshots";

    public static String captureScreenshot(
            WebDriver driver, String testName) {

        if (driver == null) {
            System.err.println("Screenshot skipped: WebDriver is null.");
            return null;
        }

        try {
            Path directory = Paths.get(SCREENSHOT_DIR);
            Files.createDirectories(directory);

            String timestamp = LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS"));

            String safeTestName = testName.replaceAll(
                    "[^a-zA-Z0-9_-]", "_");

            Path destination = directory.resolve(
                    safeTestName + "_" + timestamp + ".png");

            File screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            Files.copy(screenshot.toPath(), destination);

            String absolutePath = destination.toAbsolutePath().toString();

            System.out.println("Failure screenshot saved: " + absolutePath);

            return absolutePath;

        } catch (IOException | RuntimeException e) {
            System.err.println(
                    "Failed to capture screenshot: " + e.getMessage());
            return null;
        }
    }
}
