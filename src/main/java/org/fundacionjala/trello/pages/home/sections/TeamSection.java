package org.fundacionjala.trello.pages.home.sections;

import org.openqa.selenium.WebDriver;

public final class TeamSection extends BodySection {

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
    }
}
