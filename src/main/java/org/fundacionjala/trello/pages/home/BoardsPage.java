package org.fundacionjala.trello.pages.home;

import org.fundacionjala.trello.pages.home.sections.BoardSection;
import org.fundacionjala.trello.pages.home.sections.BodySection;
import org.fundacionjala.trello.pages.home.sections.TeamSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class BoardsPage extends HomePage {

    private static final String STICKY_CONTAINER = "div.home-sticky-container";
    private static final String MOD_ADD_BOARD = "li.boards-page-board-section-list-item div.mod-add span";
    @FindBy(css = STICKY_CONTAINER)
    private WebElement container;

    @FindBy(css = MOD_ADD_BOARD)
    private WebElement createBoardButton;

    public BoardsPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return container.isDisplayed() && createBoardButton.isDisplayed();
    }

    public BodySection getSection(final String section) {
        wait.until(ExpectedConditions.visibilityOf(container));
        wait.until(ExpectedConditions.visibilityOf(createBoardButton));

        switch (section) {
            case "member":
            case "clock":
                return new BoardSection(driver, section);
            default:
                return new TeamSection(driver, section);
        }
    }
}
