package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.When;
import org.fundacionjala.core.ui.pages.forms.FormPage;
import org.fundacionjala.trello.pages.menus.Header;

import java.util.Map;

import static org.fundacionjala.core.ui.DriverFactory.getChromeDriver;

public final class HeaderStepDefs {

    private FormPage<?> form;
    private Header header;

    public HeaderStepDefs() {
        header = new Header(getChromeDriver());
    }

    /**
     * Creates an object from header.
     *
     * @param entity Element to be created.
     * @param data   Elements values.
     */
    @When("I create a {string} from header with the following data")
    public void createEntityWithData(final String entity, final Map<String, String> data) {
        form = header.createElement(entity);
        form.fillForm(data);
        form.submit();
    }

    /**
     * Navigates to boards menu in the header.
     */
    @When("I navigate to boards menu from header")
    public void iNavigateToBoardsPage() {
        header.getMenuBoards();
    }
}
