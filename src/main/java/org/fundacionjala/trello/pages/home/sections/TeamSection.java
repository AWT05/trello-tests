package org.fundacionjala.trello.pages.home.sections;

import org.openqa.selenium.WebDriver;

public class TeamSection extends BodySection {
    public TeamSection(WebDriver driver, String name) {
        super(driver, name);
    }

    @Override
    protected void initialize(String section) {
        baseSelector = String.format("//h3[contains(text(),'%s')]", section);
        sectionNameSelector = baseSelector;

        String xpathBaseBoard = baseSelector + "/parent::div/following-sibling::div";
        listBoardsSelector = xpathBaseBoard + "/ul/li//a";
        boardSelector = xpathBaseBoard + "//div[@title='%s']//ancestor::a";
        createBoardSelector = xpathBaseBoard + "//div[@class='board-tile mod-add']";
    }
}
