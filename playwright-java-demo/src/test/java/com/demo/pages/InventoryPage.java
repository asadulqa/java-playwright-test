package com.demo.pages;

import com.demo.locators.SauceDemoLocators;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

public class InventoryPage extends BasePage {

    public InventoryPage(Page page) {
        super(page);
    }

    public void waitForPage() {
        waitFor(SauceDemoLocators.INVENTORY_LIST);
    }

    public boolean isDisplayed() {
        return isVisible(SauceDemoLocators.INVENTORY_LIST);
    }

    public String getPageHeading() {
        return getText(SauceDemoLocators.PAGE_TITLE);
    }

    public int getProductCount() {
        return locator(SauceDemoLocators.INVENTORY_ITEMS).count();
    }

    public void addBackpackToCart() {
        click(SauceDemoLocators.ADD_TO_CART_BACKPACK);
    }

    public void removeBackpackFromCart() {
        click(SauceDemoLocators.REMOVE_BACKPACK);
    }

    public void addBikeLightToCart() {
        click(SauceDemoLocators.ADD_TO_CART_BIKE_LIGHT);
    }

    public void addOnesieToCart() {
        click(SauceDemoLocators.ADD_TO_CART_ONESIE);
    }

    public void openCart() {
        click(SauceDemoLocators.SHOPPING_CART_LINK);
    }

    public String getCartBadgeCount() {
        return getText(SauceDemoLocators.CART_BADGE);
    }

    public boolean isCartBadgeVisible() {
        return isVisible(SauceDemoLocators.CART_BADGE);
    }

    public void sortByPriceLowToHigh() {
        locator(SauceDemoLocators.PRODUCT_SORT)
                .selectOption(new SelectOption().setValue("lohi"));
    }

    public List<String> getProductPrices() {
        return locator(SauceDemoLocators.INVENTORY_ITEM_PRICE).allInnerTexts();
    }

    public void logout() {
        click(SauceDemoLocators.BURGER_MENU);
        waitFor(SauceDemoLocators.LOGOUT_LINK);
        click(SauceDemoLocators.LOGOUT_LINK);
    }

    public void openProductByName(String productName) {
        locator(SauceDemoLocators.INVENTORY_ITEM_NAME)
                .filter(new com.microsoft.playwright.Locator.FilterOptions().setHasText(productName))
                .click();
    }
}
