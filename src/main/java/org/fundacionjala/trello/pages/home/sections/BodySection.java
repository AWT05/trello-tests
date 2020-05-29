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


    public BodySection(WebDriver driver, String section) {
        super(driver);
        initialize(section);
    }

    protected abstract void initialize(String section);

    @Override
    public String getName() {
        By sectionName = By.xpath(sectionNameSelector);
        WebElement name = driver.findElement(sectionName);
        return name.getText();
    }

    @Override
    public List<WebElement> getBoards() {
        By boardsXpath = By.xpath(listBoardsSelector);
        return driver.findElements(boardsXpath);
    }

    @Override
    public BoardPage getBoard(String title) {
        By boardXpath = By.xpath(String.format(boardSelector, title));
        click(driver.findElement(boardXpath));
        return new BoardPage(driver);
    }

    @Override
    public boolean isDisplayed() {
        By iconSelector = By.xpath(baseSelector);
        WebElement icon = driver.findElement(iconSelector);
        return icon.isDisplayed();
    }

    @Override
    public BoardForm createBoard() {
        By buttonLocation = By.xpath(createBoardSelector);
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonLocation));
        WebElement button = driver.findElement(buttonLocation);
        click(button);
        return new BoardForm(driver);
    }
}
