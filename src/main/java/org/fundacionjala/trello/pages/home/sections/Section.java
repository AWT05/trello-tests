package org.fundacionjala.trello.pages.home.sections;

import org.fundacionjala.trello.pages.board.BoardForm;
import org.fundacionjala.trello.pages.board.BoardPage;
import org.fundacionjala.trello.pages.core.WebObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class Section extends WebObject {

    public Section(final WebDriver driver) {
        super(driver);
    }

    /**
     * Gets section name.
     *
     * @return string name.
     */
    public abstract String getName();

    /**
     * Gets the list of boards in the section.
     *
     * @return Web elements of board type.
     */
    public abstract List<WebElement> getBoards();

    /**
     * Gets the page of the board that matches the given name.
     *
     * @param name Board name.
     * @return Board page.
     */
    public abstract BoardPage getBoard(String name);

    /**
     * Opens the form page to create a board.
     *
     * @return Board form page.
     */
    public abstract BoardForm createBoard();
}
