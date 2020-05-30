package org.fundacionjala.trello.pages.login;

import org.fundacionjala.trello.config.Environment;
import org.fundacionjala.trello.pages.core.WebObject;
import org.fundacionjala.trello.pages.home.BoardsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class LoginPage extends WebObject {

    private static final String URI = "/login";
    private static final String USER_ID = "#user";
    private static final String PASSWORD_ID = "#password";
    private static final String LOGIN = "input.account-button";
    private static final String LOGIN_ATLASSIAN = "input#login";
    private static final String LOGIN_SUBMIT_ATLASSIAN = "#login-submit";

    @FindBy(css = USER_ID)
    private WebElement username;

    @FindBy(css = PASSWORD_ID)
    private WebElement password;

    @FindBy(css = LOGIN)
    private WebElement button;

    @FindBy(css = LOGIN_ATLASSIAN)
    private WebElement initAtlassianButton;

    @FindBy(css = LOGIN_SUBMIT_ATLASSIAN)
    private WebElement submitAtlassianButton;

    public LoginPage(final WebDriver driver) {
        super(driver);
        String url = Environment.getInstance().getUiBaseUrl();
        driver.get(url.concat(URI));
    }

    @Override
    public boolean isDisplayed() {
        return button.isDisplayed();
    }

    public LoginPage setCredentials(final String username, final String password) {
        action.setInputField(this.username, username);
        if (initAtlassianButton.isDisplayed()) {
            loginWithAtlassian();
        }
        action.setInputField(this.password, password);
        return this;
    }

    public void loginWithAtlassian() {
        action.click(initAtlassianButton);
        By loginAtlassian = By.cssSelector(LOGIN_SUBMIT_ATLASSIAN);
        wait.until(ExpectedConditions.elementToBeClickable(loginAtlassian));
    }

    public BoardsPage submit() {
        if (submitAtlassianButton.isDisplayed()) {
            button = submitAtlassianButton;
        }
        action.click(button);
        return new BoardsPage(driver);
    }
}
