package com.aiqa.ecommerce.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

        private final WebDriver driver;
        private final WebDriverWait wait;

        private final By addToCartButton = By.cssSelector("a[onclick='addToCart()']");

        private final By cartLink = By.id("cartur");

        private final By cartRows = By.cssSelector("#tbodyid tr");

        private final By placeOrderButton = By.cssSelector("button[data-target='#orderModal']");

        private final By nameField = By.id("name");
        private final By countryField = By.id("country");
        private final By cityField = By.id("city");
        private final By cardField = By.id("card");
        private final By monthField = By.id("month");
        private final By yearField = By.id("year");

        private final By purchaseButton = By.cssSelector("button[onclick='purchaseOrder()']");

        private final By confirmationTitle = By.cssSelector(".sweet-alert h2");

        public CartPage(WebDriver driver, WebDriverWait wait) {
                this.driver = driver;
                this.wait = wait;
        }

        public void addCurrentProductToCart() {
                By productTitle = By.cssSelector(".name");
                By addToCartLink = By.linkText("Add to cart");

                wait.until(
                                ExpectedConditions.visibilityOfElementLocated(productTitle));

                wait.until(
                                ExpectedConditions.elementToBeClickable(addToCartLink)).click();

                Alert alert = wait.until(ExpectedConditions.alertIsPresent());

                alert.accept();
        }

        public void openCart() {
                wait.until(ExpectedConditions
                                .elementToBeClickable(cartLink)).click();

                wait.until(ExpectedConditions
                                .visibilityOfElementLocated(
                                                By.id("tbodyid")));
        }

        public boolean containsProduct(String productName) {
                List<WebElement> rows = wait.until(
                                ExpectedConditions
                                                .visibilityOfAllElementsLocatedBy(cartRows));

                return rows.stream().anyMatch(row -> row.getText().contains(productName));
        }

        public void clickPlaceOrder() {
                wait.until(ExpectedConditions
                                .elementToBeClickable(placeOrderButton)).click();

                wait.until(ExpectedConditions
                                .visibilityOfElementLocated(nameField));
        }

        public void fillOrderDetails() {
                driver.findElement(nameField).sendKeys("QA Test User");
                driver.findElement(countryField).sendKeys("India");
                driver.findElement(cityField).sendKeys("Pune");

                // Fictitious data for the demo application only.
                driver.findElement(cardField).sendKeys("4111111111111111");
                driver.findElement(monthField).sendKeys("10");
                driver.findElement(yearField).sendKeys("2027");
        }

        public void purchaseOrder() {
                wait.until(ExpectedConditions
                                .elementToBeClickable(purchaseButton)).click();
        }

        public String getConfirmationMessage() {
                return wait.until(ExpectedConditions
                                .visibilityOfElementLocated(confirmationTitle))
                                .getText();
        }
}