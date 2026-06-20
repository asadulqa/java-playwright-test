package com.demo.locators;

public final class SauceDemoLocators {

    private SauceDemoLocators() {
    }

    public static final String BASE_URL = "https://www.saucedemo.com/";

    // Login
    public static final String USERNAME_INPUT = "[data-test=\"username\"]";
    public static final String PASSWORD_INPUT = "[data-test=\"password\"]";
    public static final String LOGIN_BUTTON = "[data-test=\"login-button\"]";
    public static final String ERROR_MESSAGE = "[data-test=\"error\"]";

    // Inventory
    public static final String PAGE_TITLE = "[data-test=\"title\"]";
    public static final String INVENTORY_LIST = "[data-test=\"inventory-list\"]";
    public static final String INVENTORY_ITEMS = "[data-test=\"inventory-item\"]";
    public static final String PRODUCT_SORT = "[data-test=\"product-sort-container\"]";
    public static final String INVENTORY_ITEM_NAME = "[data-test=\"inventory-item-name\"]";
    public static final String INVENTORY_ITEM_PRICE = "[data-test=\"inventory-item-price\"]";
    public static final String ADD_TO_CART_BACKPACK = "[data-test=\"add-to-cart-sauce-labs-backpack\"]";
    public static final String REMOVE_BACKPACK = "[data-test=\"remove-sauce-labs-backpack\"]";
    public static final String ADD_TO_CART_BIKE_LIGHT = "[data-test=\"add-to-cart-sauce-labs-bike-light\"]";
    public static final String ADD_TO_CART_ONESIE = "[data-test=\"add-to-cart-sauce-labs-onesie\"]";
    public static final String SHOPPING_CART_LINK = "[data-test=\"shopping-cart-link\"]";
    public static final String CART_BADGE = "[data-test=\"shopping-cart-badge\"]";

    // Navigation
    public static final String BURGER_MENU = "#react-burger-menu-btn";
    public static final String LOGOUT_LINK = "#logout_sidebar_link";

    // Cart
    public static final String CART_LIST = "[data-test=\"cart-list\"]";
    public static final String CART_ITEM = ".cart_item";
    public static final String CHECKOUT_BUTTON = "[data-test=\"checkout\"]";
    public static final String CONTINUE_SHOPPING = "[data-test=\"continue-shopping\"]";

    // Checkout step one
    public static final String FIRST_NAME = "[data-test=\"firstName\"]";
    public static final String LAST_NAME = "[data-test=\"lastName\"]";
    public static final String POSTAL_CODE = "[data-test=\"postalCode\"]";
    public static final String CONTINUE_BUTTON = "[data-test=\"continue\"]";
    public static final String CANCEL_BUTTON = "[data-test=\"cancel\"]";

    // Checkout step two
    public static final String FINISH_BUTTON = "[data-test=\"finish\"]";
    public static final String COMPLETE_HEADER = "[data-test=\"complete-header\"]";
    public static final String COMPLETE_TEXT = "[data-test=\"complete-text\"]";
    public static final String SUBTOTAL_LABEL = "[data-test=\"subtotal-label\"]";
}
