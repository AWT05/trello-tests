package org.fundacionjala.trello.pages.home.sections;

import org.fundacionjala.trello.pages.team.TeamPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class TeamSection extends BodySection {
    private static final String TEAM_NAME = "//h3[contains(text(),'%s')]";
    public static final String BASE_BOARD = "/parent::div/following-sibling::div";
    public static final String LIST_BOARDS = "/ul/li//a";
    public static final String SPECIFIC_BOARD = "//div[@title='%s']//ancestor::a";
    public static final String ADD_BOARD = "//div[@class='board-tile mod-add']";
    private static final String BOARDS_BUTTON = "/following-sibling::div//a/span[contains(@class,'icon-board')]/parent::a";

    private String boardsOption;

    public TeamSection(final WebDriver driver, final String name) {
        super(driver, name);
    }

    @Override
    protected void initialize(final String section) {
        baseSelector = String.format(TEAM_NAME, section);
        sectionNameSelector = baseSelector;
        String xpathBaseBoard = baseSelector + BASE_BOARD;
        listBoardsSelector = xpathBaseBoard + LIST_BOARDS;
        boardSelector = xpathBaseBoard + SPECIFIC_BOARD;
        createBoardSelector = xpathBaseBoard + ADD_BOARD;
        boardsOption = baseSelector.concat(BOARDS_BUTTON);
    }

    public TeamPage openTeamBoards() {
        By boards = By.xpath(boardsOption);
        action.click(driver.findElement(boards));
        return new TeamPage(driver);
    }
}
