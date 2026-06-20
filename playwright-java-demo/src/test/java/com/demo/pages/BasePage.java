package com.demo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class BasePage {

    protected final Page page;

    protected BasePage(Page page) {
        this.page = page;
    }

    protected void navigate(String url) {
        page.navigate(url);
    }

    protected Locator locator(String selector) {
        return page.locator(selector);
    }

    protected void click(String selector) {
        locator(selector).click();
    }

    protected void fill(String selector, String text) {
        locator(selector).fill(text);
    }

    protected void type(String selector, String text) {
        locator(selector).pressSequentially(text);
    }

    protected void press(String selector, String key) {
        locator(selector).press(key);
    }

    protected void waitFor(String selector) {
        locator(selector).waitFor();
    }

    protected boolean isVisible(String selector) {
        return locator(selector).isVisible();
    }

    protected String getText(String selector) {
        return locator(selector).innerText();
    }

    protected String getTitle() {
        return page.title();
    }

    public void takeScreenshot(Path path) throws IOException {
        Files.createDirectories(path.getParent());
        page.screenshot(new Page.ScreenshotOptions().setPath(path));
    }
}
