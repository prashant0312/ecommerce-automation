package com.aiqa.ecommerce.base;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected static final String BASE_URL =
            "https://www.demoblaze.com/";

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

        if ("true".equalsIgnoreCase(System.getenv("CI"))) {
            options.addArguments(
                    "--headless=new",
                    "--no-sandbox",
                    "--disable-dev-shm-usage",
                    "--window-size=1920,1080");
        }

        // Use the manually installed driver on Windows.
        // On CI or other systems, let Selenium Manager resolve it.
        String os = System.getProperty("os.name").toLowerCase();
        String userHome = System.getProperty("user.home");

        File localDriver = new File(
                userHome
                        + File.separator + ".cache"
                        + File.separator + "selenium"
                        + File.separator + "chromedriver"
                        + File.separator + "win64"
                        + File.separator + "156.0.8078.48"
                        + File.separator + "chromedriver.exe");

        if (os.contains("windows") && localDriver.isFile()) {
            ChromeDriverService service =
                    new ChromeDriverService.Builder()
                            .usingDriverExecutable(localDriver)
                            .build();

            driver = new ChromeDriver(service, options);
        } else {
            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get(BASE_URL);
    }

    public WebDriver getDriverForReporting() {
        return driver;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } finally {
            driver = null;
        }
    }
}
