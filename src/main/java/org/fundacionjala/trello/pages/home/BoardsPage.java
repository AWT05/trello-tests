package org.fundacionjala.trello.pages.home;

import org.fundacionjala.trello.pages.home.sections.BoardSection;
import org.fundacionjala.trello.pages.home.sections.Section;
import org.fundacionjala.trello.pages.home.sections.TeamSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public Section getSection(String section) {
        return new BoardSection(driver, section);
    }

    public TeamSection getTeamSection(String teamName) {
        return new TeamSection(driver, teamName);
    }

    @Override
    public boolean isDisplayed() {
        return container.isDisplayed() && createBoardButton.isDisplayed();
    }
}
