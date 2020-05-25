package org.fundacionjala.trello.pages.login;

import org.fundacionjala.trello.pages.home.BoardsPage;
import org.fundacionjala.trello.pages.trello.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class LoginAtlassianPage extends PageObject {
    public static final String PASSWORD = "#password";
    public static final String LOGIN_SUBMIT = "#login-submit";

    @FindBy(css = PASSWORD)
    private WebElement password;

    @FindBy(css = LOGIN_SUBMIT)
    private WebElement submitButton;

    public LoginAtlassianPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return submitButton.isDisplayed();
    }

    public LoginAtlassianPage setPassword(final String value) {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        password.sendKeys(value);
        return this;
    }

    public BoardsPage submit() {
        click(submitButton);
        return new BoardsPage(driver);
    }
}
