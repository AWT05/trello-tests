package org.fundacionjala.trello.pages.home.sections;

import org.openqa.selenium.WebDriver;

public class BoardSection extends BodySection {
    public BoardSection(WebDriver driver, String name) {
        super(driver, name);
    }

    @Override
    protected void initialize(String section) {
        baseSelector = String.format("//span[contains(@class,'icon-%s')]", section);
        sectionNameSelector = baseSelector.concat("/parent::div/following-sibling::h3");

        String xpathBaseBoard = baseSelector + "/parent::div/parent::div/following-sibling::div/ul/li";
        listBoardsSelector = xpathBaseBoard + "//a";
        boardSelector = xpathBaseBoard + "/a/div//div[@title='%s']";
        createBoardSelector = xpathBaseBoard + "//div[@class='board-tile mod-add']";
    }
}
