package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.When;
import org.fundacionjala.core.ui.pages.forms.FormPage;
import org.fundacionjala.trello.driver.SharedDriver;
import org.fundacionjala.trello.pages.menus.Header;

import java.util.Map;

import static org.fundacionjala.trello.driver.DriverFactory.getDriver;

public final class HeaderStepDefs {

    private FormPage<?> form;
    private Header header;

    public HeaderStepDefs(final SharedDriver sharedDriver) {
        header = new Header(getDriver());
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

    @When("I navigate to notifications")
    public void iNavigateToNotifications() {
        header.openNotifications();
    }

    @ParameterType("added|removed")
    public String type(final String value) {
        return value.contains("add")
                ? value.replace("ed", "")
                : value.replace("ed", "e");
    }

    /**
     * Selects a notification.
     *
     * @param type      notification type.
     * @param boardName name of the board.
     */
    @When("I open notification: {type} to {string} board")
    public void selectBoardNotification(final String type, final String boardName) {
        header.selectBoardNotification(type, boardName);
    }
}
