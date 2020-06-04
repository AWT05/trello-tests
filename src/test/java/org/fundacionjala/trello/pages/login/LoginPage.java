package org.fundacionjala.trello.pages.login;

import java.util.concurrent.TimeUnit;

import org.fundacionjala.core.Environment;
import org.fundacionjala.core.ui.pages.WebObject;
import org.fundacionjala.trello.pages.home.BoardsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class LoginPage extends WebObject {

    private static final String URI = "/login";
    private static final String USER_ID = "#user";
    private static final String PASSWORD_ID = "#password";
    private static final String PASSWORD_CONTAINER = "#password-entry";
    private static final String LOGIN = "[type=\"submit\"]";
    private static final String LOGIN_SUBMIT_ATLASSIAN = "#login-submit";
    private static final String CLASS = "class";
    private static final String HIDDEN_VALUE = "hidden";

    @FindBy(css = USER_ID)
    private WebElement username;

    @FindBy(css = PASSWORD_ID)
    private WebElement password;

    @FindBy(css = LOGIN)
    private WebElement button;

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
        waitIfLoginWithAtlassian();
        action.setInputField(this.password, password);
        return this;
    }

    public void waitIfLoginWithAtlassian() {
        Environment env = Environment.getInstance();
        try {
            By selector = By.cssSelector(PASSWORD_CONTAINER);
            wait.withTimeout(env.getReducedTime(), TimeUnit.SECONDS);
            wait.until(ExpectedConditions.attributeContains(selector, CLASS, HIDDEN_VALUE));
        } catch (TimeoutException ex) {
            return;
        } finally {
            wait.withTimeout(env.getExplicitTimeWait(), TimeUnit.SECONDS);
        }
        action.click(button);
        By loginAtlassian = By.cssSelector(LOGIN_SUBMIT_ATLASSIAN);
        wait.until(ExpectedConditions.elementToBeClickable(loginAtlassian));
    }

    public BoardsPage submit() {
        action.click(button);
        return new BoardsPage(driver);
    }
}
