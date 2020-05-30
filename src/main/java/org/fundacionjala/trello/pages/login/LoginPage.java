package org.fundacionjala.trello.pages.login;

import org.fundacionjala.trello.config.Environment;
import org.fundacionjala.trello.pages.core.WebObject;
import org.fundacionjala.trello.pages.home.BoardsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class LoginPage extends WebObject {

    private static final String URI = "/login";
    private static final String USER_ID = "#user";
    private static final String PASSWORD_ID = "#password";
    private static final String LOGIN = "input.account-button";
    public static final String LOGIN_ATLASSIAN = "input#login";

    @FindBy(css = USER_ID)
    private WebElement username;

    @FindBy(css = PASSWORD_ID)
    private WebElement password;

    @FindBy(css = LOGIN)
    private WebElement button;

    @FindBy(css = LOGIN_ATLASSIAN)
    private WebElement initWithAtlassian;

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
        action.setInputField(this.password, password);
        return this;
    }

    public LoginAtlassianPage loginWithAtlassian(final String email) {
        username.sendKeys(email);
        action.click(initWithAtlassian);
        return new LoginAtlassianPage(driver);
    }

    public BoardsPage submit() {
        action.click(button);
        return new BoardsPage(driver);
    }
}
