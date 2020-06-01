package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.When;
import org.fundacionjala.trello.context.ContextTrello;
import org.fundacionjala.trello.pages.home.BoardsPage;
import org.fundacionjala.trello.pages.home.sections.Section;

import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;

public class BoardsStepDef {

    private ContextTrello context;
    private Section section;
    private final BoardsPage boardsPage;

    public BoardsStepDef(final ContextTrello context) {
        this.context = context;
        this.boardsPage = new BoardsPage(getChromeDriver());
    }

    /**
     * Navigates in the body of the home boards page and goes to the given section.
     *
     * @param name section name.
     */
    @When("I navigate to {string} section")
    public void navigateToSection(final String name) {
        section = boardsPage.getSection(name);
    }

    /**
     * Selects a board tile from a section.
     *
     * @param name board name.
     */
    @When("I select {string} board")
    public void selectBoardFromSection(final String name) {
        section.getBoard(name);
    }
}
