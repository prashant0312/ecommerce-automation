package com.aiqa.ecommerce.reports;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReportManager {

    private static ExtentReports extentReports;

    private ExtentReportManager() {
    }

    public static synchronized ExtentReports getInstance() {
        if (extentReports == null) {
            try {
                Path reportDirectory =
                        Path.of("target", "ExtentReports");

                Files.createDirectories(reportDirectory);

                ExtentSparkReporter sparkReporter =
                        new ExtentSparkReporter(
                                reportDirectory.resolve(
                                        "ExtentReport.html"
                                ).toString()
                        );

                sparkReporter.config().setDocumentTitle(
                        "AI QA Automation Test Report"
                );
                sparkReporter.config().setReportName(
                        "E-commerce Automation Results"
                );

                extentReports = new ExtentReports();
                extentReports.attachReporter(sparkReporter);

                extentReports.setSystemInfo(
                        "Framework", "Selenium + TestNG"
                );
                extentReports.setSystemInfo(
                        "Language", "Java 21"
                );
                extentReports.setSystemInfo(
                        "Build Tool", "Maven"
                );

            } catch (IOException e) {
                throw new IllegalStateException(
                        "Unable to initialize ExtentReports", e
                );
            }
        }

        return extentReports;
    }
}
