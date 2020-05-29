package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.When;
import org.fundacionjala.trello.context.Context;
import org.fundacionjala.trello.pages.home.BoardsPage;
import org.fundacionjala.trello.pages.home.sections.Section;

import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;
import static org.testng.Assert.assertTrue;

public class HomeBoardsStepDef {

    private Context context;
    private Section section;

    public HomeBoardsStepDef(Context context) {
        this.context = context;
    }

    @When("I navigate to {string} section")
    public void iNavigateToSection(String name) {
        BoardsPage boardsPage = new BoardsPage(getChromeDriver());
        assertTrue(boardsPage.isDisplayed());
        section = boardsPage.getSection(name);
    }

    @When("I navigate to {string} team section")
    public void iNavigateToTeamSection(String team) {
        BoardsPage boardsPage = new BoardsPage(getChromeDriver());
        assertTrue(boardsPage.isDisplayed());
        section = boardsPage.getTeamSection(team);
    }

    @When("I select {string} board")
    public void selectBoard(String name) {
        section.getBoard(name);
    }
}
