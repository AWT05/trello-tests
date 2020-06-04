package org.fundacionjala.trello.pages.team;

import org.fundacionjala.trello.pages.PageObject;
import org.fundacionjala.trello.pages.home.BoardsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.trello.driver.DriverFactory.getDriver;

public final class TeamPage extends PageObject {

    private static final String TEAM_NAME = "div.tabbed-pane-header-details > div > div > div > h1";
    private static final String TEAM_SETTINGS = "a[data-tab=\"settings\"]";
    private static final String XPATH_BOARD_TILE = "//div[contains(@title, '%s')]//ancestor::a[@class='board-tile']";

    @FindBy(css = TEAM_NAME)
    private WebElement teamName;

    @FindBy(css = TEAM_SETTINGS)
    private WebElement teamSettings;

    public TeamPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return teamName.isDisplayed() && teamSettings.isDisplayed();
    }

    public String getTeamName() {
        action.waitUntilLoad(teamName);
        if (isDisplayed()) {
            return action.getElementText(teamName);
        } else {
            return "Error: Team not found.";
        }
    }

    /**
     * Navigates to settings tab and opens the new page.
     *
     * @return A team settings object.
     */
    public TeamSettings goToSettings() {
        action.click(teamSettings);
        return new TeamSettings(getDriver());
    }

    public BoardsPage openBoard(final String name) {
        isDisplayed();
        By boardTile = By.xpath(String.format(XPATH_BOARD_TILE, name));
        action.click(driver.findElement(boardTile));
        return new BoardsPage(driver);
    }
}