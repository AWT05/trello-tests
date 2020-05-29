package org.fundacionjala.trello.pages.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Bases object that represent a web element.
 */
public abstract class WebObject {

    private static final int SECONDS = 20;
    protected final WebDriverWait wait;
    protected final WebDriver driver;

    public WebObject(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, SECONDS);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, SECONDS), this);
    }

    /**
     * Indicates if the actual page is displayed.
     *
     * @return true if actual page is displayed, else false.
     */
    public abstract boolean isDisplayed();

    /**
     * Makes click in the web element.
     *
     * @param element web element.
     */
    public void click(final WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * Waits for an element to be fully loaded and visible.
     *
     * @param element web element.
     */
    public void waitUntilLoad(final WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
