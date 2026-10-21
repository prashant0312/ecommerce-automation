package com.aiqa.ecommerce.tests;

import com.aiqa.ecommerce.base.BaseTest;
import com.aiqa.ecommerce.pages.HomePage;
import com.aiqa.ecommerce.pages.CartPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void verifyHomePageTest() {
        HomePage homePage = new HomePage(driver, wait);

        Assert.assertTrue(
                homePage.isHomePageDisplayed(),
                "Homepage should display the product store");
    }

    @Test
    public void productCartAndCheckoutTest() {
        HomePage homePage = new HomePage(driver, wait);
        CartPage cartPage = new CartPage(driver, wait);

        // TC04: Open a product and verify its details.
        String selectedProduct = homePage.openFirstProduct();

        Assert.assertEquals(
                homePage.getProductDetailsName(),
                selectedProduct,
                "Product details should match the selected product");

        // TC05: Add the product to the cart and verify it.
        cartPage.addCurrentProductToCart();
        cartPage.openCart();

        Assert.assertTrue(
                cartPage.containsProduct(selectedProduct),
                "Selected product should appear in the cart");

        // TC06: Place the order and verify confirmation.
        cartPage.clickPlaceOrder();
        cartPage.fillOrderDetails();
        cartPage.purchaseOrder();

        String confirmation =
                cartPage.getConfirmationMessage();

        Assert.assertTrue(
                confirmation.toLowerCase().contains("thank"),
                "Expected order confirmation, but received: "
                        + confirmation);
    }
}
