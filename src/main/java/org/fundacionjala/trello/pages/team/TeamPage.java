package org.fundacionjala.trello.pages.team;

import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;
import org.fundacionjala.trello.pages.core.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class TeamPage extends PageObject {

    private static final String TEAM_NAME = "div.tabbed-pane-header-details > div > div > div > h1";
    private static final String TEAM_SETTINGS = "a[data-tab=\"settings\"]";

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

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getTeamName() {
        if (isDisplayed()) {
            return teamName.getText();
        } else {
            return "Error: Team not found.";
        }
    }

    public TeamSettings goToSettings() {
        click(teamSettings);
        return new TeamSettings(getChromeDriver());
    }
}
