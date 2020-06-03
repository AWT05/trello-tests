package org.fundacionjala.core.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverAction {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public WebDriverAction(final WebDriver driver, final WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

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
     * Set a input field using a webElement and a content.
     *
     * @param webElement web element.
     * @param content to set the field.
     */
    public void setInputField(final WebElement webElement, final String content) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(content);
    }

    /**
     * Gets the text on a specific webElement.
     *
     * @param webElement web element.
     * @return a string with the element text.
     */
    public String getElementText(final WebElement webElement) {
        wait.until(ExpectedConditions.attributeToBeNotEmpty(webElement, "innerText"));
        return webElement.getText();
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
