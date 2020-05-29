package org.fundacionjala.trello.pages.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.Keys.ENTER;

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
     * Set a input field using a webElement and a content.
     *
     * @param webElement web element.
     */
    public void setInputField(WebElement webElement, String content) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(content);
    }

    /**
     * Gets the text on a specific webElement.
     *
     * @param webElement  web element.
     * @return a string with the element text.
     */
    public String getElementText(WebElement webElement){
        wait.until(ExpectedConditions.attributeToBeNotEmpty(webElement,"innerText"));
        return webElement.getText();
    }
}
