package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.context.Context;
import org.fundacionjala.trello.pages.board.BoardPage;
import org.fundacionjala.trello.pages.board.MenuBoard;
import org.fundacionjala.trello.pages.forms.FormPage;
import org.fundacionjala.trello.pages.list.ListPage;

import java.util.Map;

import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;
import static org.testng.Assert.assertEquals;

public class ListStepDef {

    private final Context context;
    private BoardPage boardPage;
    private MenuBoard menuBoard;
    private ListPage listPage;
    private FormPage<?> form;

    public ListStepDef(final Context context){
        this.context = context;
    }


    @When("I create a List with:")
    public void iCreateAListWith(final Map<String, String> data) {
        boardPage = new BoardPage(getChromeDriver());
        menuBoard = new MenuBoard(getChromeDriver());
        if (menuBoard.isDisplayed()) {
            menuBoard.closeMenuOptions();
        }
        form = boardPage.createNewList();
        form.fillForm(data);
        form.submit();
    }

    @Then("I should have a list created with:")
    public void iShouldHaveAListCreatedWith(final Map<String, String> expectedData) {
        listPage = new ListPage(getChromeDriver());
        listPage.getAllListsNames().forEach(System.out::println);
        //assertEquals(expectedData.get("name"), listPage.);
    }
}
