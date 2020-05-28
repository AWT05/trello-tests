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


    @When("I create a List with:")
    public void iCreateAListWith(final Map<String, String> data) {

    }

    @Then("I should have a list created with:")
    public void iShouldHaveAListCreatedWith(final Map<String, String> data) {
    }
}
