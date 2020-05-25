package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.When;
import org.fundacionjala.trello.context.Context;
import org.fundacionjala.trello.pages.forms.FormPage;

import java.util.Map;

public final class HeaderStepDefs {

    private final Context context;
    private FormPage<?> form;

    public HeaderStepDefs(final Context context) {
        this.context = context;
    }

    @When("I create a {string} from header with the following data")
    public void createBoardWithData(final String entity, final Map<String, String> data) {
        form = context.getActualPage().getHeader().createElement(entity);
        form.fillForm(data);
        form.submit();
    }
}
