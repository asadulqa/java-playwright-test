package com.demo.pages;

import com.demo.locators.SauceDemoLocators;
import com.microsoft.playwright.Page;

public class CheckoutPage extends BasePage {

    public CheckoutPage(Page page) {
        super(page);
    }

    public void fillCustomerInfo(String firstName, String lastName, String postalCode) {
        waitFor(SauceDemoLocators.FIRST_NAME);
        fill(SauceDemoLocators.FIRST_NAME, firstName);
        fill(SauceDemoLocators.LAST_NAME, lastName);
        fill(SauceDemoLocators.POSTAL_CODE, postalCode);
    }

    public void clickContinue() {
        click(SauceDemoLocators.CONTINUE_BUTTON);
    }

    public void clickFinish() {
        waitFor(SauceDemoLocators.FINISH_BUTTON);
        click(SauceDemoLocators.FINISH_BUTTON);
    }

    public void clickCancel() {
        click(SauceDemoLocators.CANCEL_BUTTON);
    }

    public String getErrorMessage() {
        waitFor(SauceDemoLocators.ERROR_MESSAGE);
        return getText(SauceDemoLocators.ERROR_MESSAGE);
    }

    public boolean isErrorDisplayed() {
        return isVisible(SauceDemoLocators.ERROR_MESSAGE);
    }

    public String getCompleteHeader() {
        waitFor(SauceDemoLocators.COMPLETE_HEADER);
        return getText(SauceDemoLocators.COMPLETE_HEADER);
    }

    public String getCompleteText() {
        return getText(SauceDemoLocators.COMPLETE_TEXT);
    }

    public boolean isSubtotalVisible() {
        return isVisible(SauceDemoLocators.SUBTOTAL_LABEL);
    }
}
