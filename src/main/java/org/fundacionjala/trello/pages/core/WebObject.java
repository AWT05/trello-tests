package org.fundacionjala.trello.pages.core;

import org.fundacionjala.trello.utils.WebDriverAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Bases object that represent a web element.
 */
public abstract class WebObject {

    private static final int SECONDS = 20;
    protected final WebDriverWait wait;
    protected final WebDriver driver;
    protected WebDriverAction action;

    public WebObject(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, SECONDS);
        action = new WebDriverAction(driver, wait);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, SECONDS), this);
    }

    /**
     * Indicates if the actual page is displayed.
     *
     * @return true if actual page is displayed, else false.
     */
    public abstract boolean isDisplayed();
}
