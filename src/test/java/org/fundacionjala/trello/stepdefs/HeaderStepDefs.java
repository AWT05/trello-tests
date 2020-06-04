package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.When;
import org.fundacionjala.trello.context.ContextTrello;
import org.fundacionjala.trello.pages.core.PageObject;
import org.fundacionjala.trello.pages.forms.FormPage;

import java.util.Map;

public final class HeaderStepDefs {

    private final ContextTrello context;
    private FormPage<?> form;

    public HeaderStepDefs(final ContextTrello context) {
        this.context = context;
    }

    /**
     * Creates an object from header.
     *
     * @param entity Element to be created.
     * @param data   Elements values.
     */
    @When("I create a {string} from header with the following data")
    public void createEntityWithData(final String entity, final Map<String, String> data) {
        form = context.getActualPage().getHeader().createElement(entity);
        form.fillForm(data);
        context.saveActualPage((PageObject) form.submit());
    }

    /**
     * Navigates to boards menu in the header.
     */
    @When("I navigate to boards menu from header")
    public void iNavigateToBoardsPage() {
        context.getActualPage().getHeader().getMenuBoards();
    }
}
