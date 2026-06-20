package com.demo.pages;

import com.demo.locators.SauceDemoLocators;
import com.microsoft.playwright.Page;

public class CartPage extends BasePage {

    public CartPage(Page page) {
        super(page);
    }

    public void waitForPage() {
        waitFor(SauceDemoLocators.CART_LIST);
    }

    public boolean isDisplayed() {
        return isVisible(SauceDemoLocators.CART_LIST);
    }

    public int getCartItemCount() {
        return locator(SauceDemoLocators.CART_ITEM).count();
    }

    public void clickCheckout() {
        click(SauceDemoLocators.CHECKOUT_BUTTON);
    }

    public void clickContinueShopping() {
        click(SauceDemoLocators.CONTINUE_SHOPPING);
    }
}
