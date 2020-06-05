package org.fundacionjala.trello.pages.home.sections;

import org.fundacionjala.trello.pages.board.BoardForm;
import org.fundacionjala.trello.pages.board.BoardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public abstract class BodySection extends Section {

    protected String baseSelector;
    protected String sectionNameSelector;
    protected String listBoardsSelector;
    protected String boardSelector;
    protected String createBoardSelector;

    public BodySection(final WebDriver driver, final String section) {
        super(driver);
        initialize(section);
    }

    /**
     * Sets values in xpath format for special selectors:
     * <ul>
     * <li><code>baseSelector</code>: Allows identifier the section. {@link #isDisplayed()}</li>
     * <li><code>sectionNameSelector</code>: Locates the section name. {@link #getName()}</li>
     * <li><code>listBoardsSelector</code>: Locates the list of boards in the section. {@link #getBoards()}</li>
     * <li><code>boardSelector</code>: Locates a specific board in the section. {@link #getBoard(String)}</li>
     * <li><code>createBoardSelector</code>: Locate the Create Board button in the section. {@link #createBoard()}</li>
     * </ul>
     *
     * @param section Section identifier.
     */
    protected abstract void initialize(String section);

    @Override
    public final String getName() {
        By sectionName = By.xpath(sectionNameSelector);
        WebElement name = driver.findElement(sectionName);
        return name.getText();
    }

    @Override
    public final List<WebElement> getBoards() {
        By boardsXpath = By.xpath(listBoardsSelector);
        return driver.findElements(boardsXpath);
    }

    @Override
    public final BoardPage getBoard(final String title) {
        By boardLocator = By.xpath(String.format(boardSelector, title));
        action.waitForElementLocated(boardLocator);
        action.click(driver.findElement(boardLocator));
        return new BoardPage(driver);
    }

    @Override
    public final boolean isDisplayed() {
        By iconSelector = By.xpath(baseSelector);
        WebElement icon = driver.findElement(iconSelector);
        return icon.isDisplayed();
    }

    /**
     * Opens the form page to create a board.
     *
     * @return Board form page.
     */
    public BoardForm createBoard() {
        By buttonLocation = By.xpath(createBoardSelector);
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonLocation));
        WebElement button = driver.findElement(buttonLocation);
        action.click(button);
        return new BoardForm(driver);
    }
}
