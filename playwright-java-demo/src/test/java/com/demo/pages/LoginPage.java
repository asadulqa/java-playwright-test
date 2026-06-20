package com.demo.pages;

import com.demo.locators.SauceDemoLocators;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    public LoginPage(Page page) {
        super(page);
    }

    public void open() {
        navigate(SauceDemoLocators.BASE_URL);
    }

    public void login(String username, String password) {
        waitFor(SauceDemoLocators.USERNAME_INPUT);
        fill(SauceDemoLocators.USERNAME_INPUT, username);
        fill(SauceDemoLocators.PASSWORD_INPUT, password);
        click(SauceDemoLocators.LOGIN_BUTTON);
    }

    public boolean isDisplayed() {
        return isVisible(SauceDemoLocators.LOGIN_BUTTON);
    }

    public String getErrorMessage() {
        waitFor(SauceDemoLocators.ERROR_MESSAGE);
        return getText(SauceDemoLocators.ERROR_MESSAGE);
    }

    public boolean isErrorDisplayed() {
        return isVisible(SauceDemoLocators.ERROR_MESSAGE);
    }
}
