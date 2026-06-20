package com.demo.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Automated test suite for https://www.saucedemo.com/ (Swag Labs).
 */
class SauceDemoTest extends BaseTest {

    @BeforeEach
    void setUp() {
        setUpBrowser();
    }

    @AfterEach
    void tearDown() {
        tearDownBrowser();
    }

    @Test
    @DisplayName("TC01 - Valid login redirects to inventory page")
    void tc01_validLogin() {
        loginPage.open();

        assertTrue(loginPage.isDisplayed(), "Login page should be visible");

        loginPage.login(VALID_USERNAME, VALID_PASSWORD);
        inventoryPage.waitForPage();

        assertTrue(inventoryPage.isDisplayed(), "Inventory page should be visible after login");
        assertEquals("Products", inventoryPage.getPageHeading());
        assertEquals(6, inventoryPage.getProductCount());
    }

    @Test
    @DisplayName("TC02 - Invalid credentials show error message")
    void tc02_invalidLogin() {
        loginPage.open();
        loginPage.login(VALID_USERNAME, "wrong_password");

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals("Epic sadface: Username and password do not match any user in this service",
                loginPage.getErrorMessage());
    }

    @Test
    @DisplayName("TC03 - Locked out user cannot login")
    void tc03_lockedOutUser() {
        loginPage.open();
        loginPage.login(LOCKED_OUT_USERNAME, VALID_PASSWORD);

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals("Epic sadface: Sorry, this user has been locked out.",
                loginPage.getErrorMessage());
    }

    @Test
    @DisplayName("TC04 - Add single product to cart updates badge")
    void tc04_addProductToCart() {
        loginAsStandardUser();

        inventoryPage.addBackpackToCart();

        assertTrue(inventoryPage.isCartBadgeVisible());
        assertEquals("1", inventoryPage.getCartBadgeCount());
    }

    @Test
    @DisplayName("TC05 - Remove product from cart clears badge")
    void tc05_removeProductFromCart() {
        loginAsStandardUser();

        inventoryPage.addBackpackToCart();
        assertEquals("1", inventoryPage.getCartBadgeCount());

        inventoryPage.removeBackpackFromCart();

        assertFalse(inventoryPage.isCartBadgeVisible());
    }

    @Test
    @DisplayName("TC06 - Sort products by price low to high")
    void tc06_sortProductsByPriceLowToHigh() {
        loginAsStandardUser();

        inventoryPage.sortByPriceLowToHigh();

        List<String> prices = inventoryPage.getProductPrices();
        assertEquals(6, prices.size());
        assertEquals("$7.99", prices.get(0));
        assertEquals("$49.99", prices.get(prices.size() - 1));
    }

    @Test
    @DisplayName("TC07 - Complete checkout flow with success confirmation")
    void tc07_completeCheckout() {
        loginAsStandardUser();

        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();
        cartPage.waitForPage();

        assertEquals(1, cartPage.getCartItemCount());

        cartPage.clickCheckout();
        checkoutPage.fillCustomerInfo("John", "Doe", "12345");
        checkoutPage.clickContinue();

        assertTrue(checkoutPage.isSubtotalVisible());

        checkoutPage.clickFinish();

        assertEquals("Thank you for your order!", checkoutPage.getCompleteHeader());
        assertTrue(checkoutPage.getCompleteText().contains("Your order has been dispatched"));
    }

    @Test
    @DisplayName("TC08 - Logout returns user to login page")
    void tc08_logout() {
        loginAsStandardUser();

        inventoryPage.logout();

        assertTrue(loginPage.isDisplayed(), "Login page should appear after logout");
    }

    @Test
    @DisplayName("TC09 - Add multiple products updates cart badge count")
    void tc09_addMultipleProductsToCart() {
        loginAsStandardUser();

        inventoryPage.addBackpackToCart();
        inventoryPage.addBikeLightToCart();
        inventoryPage.addOnesieToCart();

        assertTrue(inventoryPage.isCartBadgeVisible());
        assertEquals("3", inventoryPage.getCartBadgeCount());

        inventoryPage.openCart();
        cartPage.waitForPage();

        assertEquals(3, cartPage.getCartItemCount());
    }

    @Test
    @DisplayName("TC10 - Checkout form validation requires customer information")
    void tc10_checkoutFormValidation() {
        loginAsStandardUser();

        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();
        cartPage.waitForPage();
        cartPage.clickCheckout();

        checkoutPage.clickContinue();

        assertTrue(checkoutPage.isErrorDisplayed());
        assertEquals("Error: First Name is required", checkoutPage.getErrorMessage());
    }
}
