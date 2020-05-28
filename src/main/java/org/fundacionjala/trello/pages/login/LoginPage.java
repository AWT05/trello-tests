package org.fundacionjala.trello.pages.login;

import org.fundacionjala.trello.config.Environment;
import org.fundacionjala.trello.pages.BasePage;
import org.fundacionjala.trello.pages.home.BoardsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class LoginPage extends BasePage {

    private static final String ENDPOINT = "/login";
    private static final String USER_ID = "#user";
    private static final String PASSWORD_ID = "#password";
    private static final String LOGIN = "input.account-button";

    @FindBy(css = USER_ID)
    private WebElement username;

    @FindBy(css = PASSWORD_ID)
    private WebElement password;

    @FindBy(css = LOGIN)
    private WebElement loginButton;

    public LoginPage(final WebDriver driver) {
        super(driver);
        String url = Environment.getInstance().getUiBaseUrl();
        driver.get(url.concat(ENDPOINT));
    }

    public LoginPage setCredentials(final String username, final String password) {
        action.setInputField(this.username, username);
        action.setInputField(this.password, password);
        return this;
    }

    public BoardsPage submit() {
        action.clickButton(loginButton);
        return new BoardsPage(driver);
    }



}
