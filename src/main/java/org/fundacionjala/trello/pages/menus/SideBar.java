package org.fundacionjala.trello.pages.menus;

import org.fundacionjala.trello.pages.trello.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class SideBar extends PageObject {

    private static final String CREATE_TEAM_BUTTON = "button[data-test-id=home-navigation-create-team-button]";

    @FindBy(css = CREATE_TEAM_BUTTON)
    private WebElement homeNavCreateTeamButton;

    public SideBar(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
