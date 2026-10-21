package com.aiqa.ecommerce.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By productLinks =
            By.cssSelector("#tbodyid .card-title a");

    private final By productName =
            By.cssSelector("#tbodyid .name");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isHomePageDisplayed() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(productLinks));

        return driver.getTitle().contains("STORE")
                && !driver.findElements(productLinks).isEmpty();
    }

    public String openFirstProduct() {
        List<WebElement> products = wait.until(
                ExpectedConditions
                        .visibilityOfAllElementsLocatedBy(productLinks));

        String selectedProduct = products.get(0).getText();

        wait.until(ExpectedConditions
                .elementToBeClickable(products.get(0))).click();

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(productName));

        return selectedProduct;
    }

    public String getProductDetailsName() {
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(productName))
                .getText();
    }

    public void openHomePage() {
        driver.get("https://www.demoblaze.com/");
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(productLinks));
    }
}
