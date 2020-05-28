package org.fundacionjala.trello.pages.team;

import org.fundacionjala.trello.pages.core.PageObject;
import org.openqa.selenium.WebDriver;

public final class TeamPage extends PageObject {

    public TeamPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
