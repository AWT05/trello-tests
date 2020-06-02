package org.fundacionjala.trello.pages.team;

import org.fundacionjala.trello.pages.IIdentifier;
import org.fundacionjala.trello.pages.core.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;

public final class TeamPage extends PageObject implements IIdentifier {

    private static final String TEAM_NAME = "div.tabbed-pane-header-details > div > div > div > h1";
    private static final String TEAM_SETTINGS = "a[data-tab=\"settings\"]";
    private static final int ID_INDEX = 0;

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
            return teamName.getText();
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
        return new TeamSettings(getChromeDriver());
    }

    @Override
    public String handleUrl() throws URISyntaxException {
        isDisplayed();
        String currentUri = new URI(driver.getCurrentUrl()).getPath();
        return Paths.get(currentUri).getName(ID_INDEX).toString();
    }
}
