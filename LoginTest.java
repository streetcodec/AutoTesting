package com.example.tests;

import com.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("validUser");
        loginPage.enterPassword("validPassword");
        loginPage.clickLogin();

        String expectedUrl = "https://example.com/dashboard"; // Replace with actual URL after login
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Failed to navigate to dashboard after login.");
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("invalidUser");
        loginPage.enterPassword("invalidPassword");
        loginPage.clickLogin();

        String errorMessage = driver.findElement(By.id("error")).getText();
        Assert.assertEquals(errorMessage, "Invalid credentials", "Expected error message not displayed.");
    }
}
