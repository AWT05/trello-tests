package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.context.Context;
import org.fundacionjala.trello.pages.home.sections.BodySection;
import org.fundacionjala.trello.pages.home.sections.Section;

import static org.fundacionjala.trello.driver.DriverFactory.getChromeDriver;

public class HomeBoardsStepDef {

    private Context context;
    private Section section;

    public HomeBoardsStepDef(Context context) {
        this.context = context;
    }

    @And("I navigate to {string} section")
    public void iNavigateToSection(String name) {
        section = new BodySection(getChromeDriver(), name);
    }

    @When("I select {string} board")
    public void selectBoard(String name) {
        section.getBoard(name);
    }
}
