package org.fundacionjala.trello.pages.home.sections;

import org.fundacionjala.trello.pages.team.TeamPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class TeamSection extends BodySection {


    private String boardsOption;

    public TeamSection(final WebDriver driver, final String name) {
        super(driver, name);
    }

    @Override
    protected void initialize(final String section) {
        baseSelector = String.format("//h3[contains(text(),'%s')]", section);
        sectionNameSelector = baseSelector;
        String xpathBaseBoard = baseSelector + "/parent::div/following-sibling::div";
        listBoardsSelector = xpathBaseBoard + "/ul/li//a";
        boardSelector = xpathBaseBoard + "//div[@title='%s']//ancestor::a";
        createBoardSelector = xpathBaseBoard + "//div[@class='board-tile mod-add']";
        String baseHref = section.replaceAll(" ", "").toLowerCase();
        String linkSelector = String.format("/following-sibling::div//a[contains(@href, '%s')][1]", baseHref);
        boardsOption = baseSelector.concat(linkSelector);
    }

    public TeamPage openTeamBoards() {
        By boards = By.xpath(boardsOption);
        action.click(driver.findElement(boards));
        return new TeamPage(driver);
    }
}
