package org.fundacionjala.trello.pages;

import org.fundacionjala.trello.webdriver.ManageDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final WebDriverAction action;

    public BasePage(final WebDriver driver) {
        this.driver = driver;
        this.wait = ManageDriver.getInstance().getWebDriverWait();
        action = new WebDriverAction(driver, wait);
        ManageDriver.getInstance().getImplicitWait();
        PageFactory.initElements(driver, this);
    }
}
