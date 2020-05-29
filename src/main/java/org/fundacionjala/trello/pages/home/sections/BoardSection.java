package org.fundacionjala.trello.pages.home.sections;

import org.openqa.selenium.WebDriver;

public final class BoardSection extends BodySection {

    public BoardSection(final WebDriver driver, final String name) {
        super(driver, name);
    }

    @Override
    protected void initialize(final String section) {
        baseSelector = String.format("//span[contains(@class,'icon-%s')]", section);
        sectionNameSelector = baseSelector.concat("/parent::div/following-sibling::h3");

        String xpathBaseBoard = baseSelector.concat("/parent::div/parent::div/following-sibling::div/ul/li");
        listBoardsSelector = xpathBaseBoard.concat("//a");
        boardSelector = xpathBaseBoard.concat("/a/div//div[@title='%s']");
        createBoardSelector = xpathBaseBoard.concat("//div[@class='board-tile mod-add']");
    }
}
