package com.aiqa.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By loginLink = By.id("login2");
    private final By usernameField = By.id("loginusername");
    private final By passwordField = By.id("loginpassword");
    private final By loginButton =
            By.cssSelector("button[onclick='logIn()']");
    private final By loggedInUsername = By.id("nameofuser");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void openLoginModal() {
        wait.until(
                ExpectedConditions.elementToBeClickable(loginLink)
        ).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(usernameField)
        );
    }

    public void enterCredentials(String username, String password) {
        WebElement usernameInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(usernameField)
        );

        usernameInput.clear();
        usernameInput.sendKeys(username);

        WebElement passwordInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(passwordField)
        );

        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        wait.until(
                ExpectedConditions.elementToBeClickable(loginButton)
        ).click();
    }

    public boolean isLoginSuccessful(String username) {
        try {
            // First check whether the application rejected the login.
            try {
                Alert alert = new WebDriverWait(
                        driver, Duration.ofSeconds(3)
                ).until(ExpectedConditions.alertIsPresent());

                System.out.println(
                        "Login rejected: " + alert.getText()
                );

                alert.accept();
                return false;

            } catch (TimeoutException e) {
                // No rejection alert appeared; check successful login.
            }

            return wait.until(
                    ExpectedConditions.textToBePresentInElementLocated(
                            loggedInUsername, username
                    )
            );

        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getLoginAlertMessage() {
        Alert alert = wait.until(
                ExpectedConditions.alertIsPresent()
        );

        String message = alert.getText();
        alert.accept();

        return message;
    }
}
