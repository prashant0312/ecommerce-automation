package com.aiqa.ecommerce.tests;

import com.aiqa.ecommerce.base.BaseTest;
import com.aiqa.ecommerce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

        
@Test
public void validLoginTest() {

    String username = System.getenv("DEMOBLAZE_USERNAME");
    String password = System.getenv("DEMOBLAZE_PASSWORD");

    Assert.assertNotNull(
            username,
            "Set DEMOBLAZE_USERNAME before running this test");

    Assert.assertNotNull(
            password,
            "Set DEMOBLAZE_PASSWORD before running this test");

    Assert.assertFalse(
            username.isBlank(),
            "DEMOBLAZE_USERNAME must not be blank");

    Assert.assertFalse(
            password.isBlank(),
            "DEMOBLAZE_PASSWORD must not be blank");

    LoginPage loginPage = new LoginPage(driver, wait);

    loginPage.openLoginModal();
    loginPage.enterCredentials(username, password);
    loginPage.clickLogin();

    Assert.assertTrue(
            loginPage.isLoginSuccessful(username),
            "Login failed. Verify the registered DemoBlaze credentials.");
}

        @Test
        public void invalidLoginTest() {
                LoginPage loginPage = new LoginPage(driver, wait);

                loginPage.openLoginModal();
                loginPage.enterCredentials(
                                "invalid_user_qa_92831",
                                "invalid_password_92831");
                loginPage.clickLogin();

                String alertMessage = loginPage.getLoginAlertMessage();

                Assert.assertTrue(
                                alertMessage.toLowerCase().contains("wrong")
                                                || alertMessage.toLowerCase().contains("exist"),
                                "Unexpected login rejection message: " + alertMessage);
        }

}
