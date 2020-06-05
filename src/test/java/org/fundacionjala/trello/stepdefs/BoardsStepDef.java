package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.When;
import org.fundacionjala.trello.driver.SharedDriver;
import org.fundacionjala.trello.pages.home.BoardsPage;
import org.fundacionjala.trello.pages.home.sections.Section;
import org.fundacionjala.trello.pages.home.sections.TeamSection;

import static org.fundacionjala.trello.driver.DriverFactory.getDriver;

public class BoardsStepDef {

    private Section section;
    private final BoardsPage boardsPage;

    public BoardsStepDef(final SharedDriver sharedDriver) {
        this.boardsPage = new BoardsPage(getDriver());
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

    /**
     * Opens the boards page for the selected team.
     */
    @When("I open the boards of the team page")
    public void openBoardsTeamPage() {
        TeamSection teamSection = (TeamSection) section;
        teamSection.openTeamBoards();
    }
}
