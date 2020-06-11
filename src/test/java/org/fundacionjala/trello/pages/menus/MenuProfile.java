package org.fundacionjala.trello.pages.menus;

import org.fundacionjala.core.ui.pages.WebObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class MenuProfile extends WebObject {

    private static final String SECTION_MEMBER = "section[data-test-id='header-member-menu-popover']";
    private static final String LOGOUT_BUTTON = "button[data-test-id='header-member-menu-logout']";

    @FindBy(css = SECTION_MEMBER)
    private WebElement sectionMember;

    @FindBy(css = LOGOUT_BUTTON)
    private WebElement logOutButton;

    public MenuProfile(final WebDriver driver) {
        super(driver);
    }

    /**
     * Indicates if the actual page is displayed.
     *
     * @return true if actual page is displayed, else false.
     */
    @Override
    public boolean isDisplayed() {
        action.waitForVisibility(sectionMember);
        return sectionMember.isDisplayed();
    }

    public void logOutSession() {
        action.waitForVisibility(logOutButton);
        action.click(logOutButton);
    }
}
