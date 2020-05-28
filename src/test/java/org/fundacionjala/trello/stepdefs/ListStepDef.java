package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.context.Context;
import org.fundacionjala.trello.pages.board.BoardPage;

import java.util.Map;

public class ListStepDef {

    private final Context context;
    private BoardPage boardPage;

    public ListStepDef(final Context context){
        this.context = context;
    }


    @And("I navigate to boards page")
    public void iNavigateToBoardsPage() {

    }

    @And("I open the {string} board")
    public void iOpenTheBoard(String boardName) {
        context.getActualPage().getHomeBoards().getBoard(boardName);

    }

    @When("I create a List with:")
    public void iCreateAListWith(final Map<String, String> data) {

    }

    @When("I update the {string} List with:")
    public void iUpdateTheListWith(final Map<String, String> data) {
    }

    @Then("I should have a list (created)(updated) with:")
    public void iShouldHaveAListCreatedWith(final Map<String, String> data) {
    }

    @When("I create a copy of {string} list")
    public void iCreateACopyOfTheCurrentList() {
    }

    @Then("I verify the information of the copied list")
    public void iVerifyTheInformationOfTheCopiedList() {
    }

    @And("I navigate to actions in the {string} list")
    public void iNavigateToActionsInTheList(String arg0) {
    }

    @When("I change the its position with {string} list")
    public void iChangeTheItsPositionWithList(String arg0) {
    }

    @Then("I verified that the lists have changed positions")
    public void iVerifiedThatTheListsHaveChangedPositions() {
    }

    @When("I archive the {string} list")
    public void iArchiveTheList(String arg0) {
    }

    @Then("I verify that the list has been archived")
    public void iVerifyThatTheListHasBeenArchived() {
    }
}
