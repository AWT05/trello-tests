package org.fundacionjala.trello.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverAction {

    private static final String INNER_TEXT = "innerText";
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
        wait.until(ExpectedConditions.attributeToBeNotEmpty(webElement, INNER_TEXT));
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

    /**
     * Waits for WebElement which contains specific value in its inner attribute.
     *
     * @param element used to check its parameters.
     * @param text used as expected attribute value.
     */
    public void waitContainsInnerText(final WebElement element, final String text) {
        wait.until(ExpectedConditions.attributeContains(element, INNER_TEXT, text));
    }

    /**
     * Waits for WebElement defined by the By object given which contains specific value in its inner attribute.
     *
     * @param element used to define WebElement to check its parameters.
     * @param text used as expected attribute value.
     */
    public void waitContainsInnerText(final By element, final String text) {
        wait.until(ExpectedConditions.attributeContains(element, INNER_TEXT, text));
    }
}
