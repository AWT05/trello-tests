package org.fundacionjala.trello.pages.login;

import org.fundacionjala.trello.config.Environment;
import org.fundacionjala.trello.pages.home.BoardsPage;
import org.fundacionjala.trello.pages.trello.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class LoginPage extends PageObject {

    private static final String ENDPOINT = "/login";
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
        driver.get(url.concat(ENDPOINT));
    }

    @Override
    public boolean isDisplayed() {
        return button.isDisplayed();
    }

    public LoginPage setCredentials(final String username, final String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        return this;
    }

    public LoginAtlassianPage loginWithAtlassian(final String email) {
        username.sendKeys(email);
        click(initWithAtlassian);
        return new LoginAtlassianPage(driver);
    }

    public BoardsPage submit() {
        click(button);
        return new BoardsPage(driver);
    }
}
