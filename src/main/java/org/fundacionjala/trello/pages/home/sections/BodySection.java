package org.fundacionjala.trello.pages.home.sections;

import org.fundacionjala.trello.pages.board.BoardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BodySection extends Section {

    private String baseSelector;
    private String baseBoardSelector;


    public BodySection(WebDriver driver, String name) {
        super(driver);
        this.baseSelector = String.format("//span[contains(@class,'icon-%s')]", name);
        this.baseBoardSelector = this.baseSelector.concat(
                "/parent::div/parent::div/following-sibling::div/ul/li");
    }

    @Override
    public String getName() {
        String nameSelector = baseSelector.concat("/parent::div/following-sibling::h3");
        By sectionName = By.xpath(nameSelector);
        WebElement name = driver.findElement(sectionName);
        return name.getText();
    }

    @Override
    public List<WebElement> getBoards() {
        String boardsSelector = baseBoardSelector.concat("//a");
        By boardsXpath = By.xpath(boardsSelector);
        return driver.findElements(boardsXpath);
    }

    @Override
    public BoardPage getBoard(String title) {
        String boardSelector = baseBoardSelector.concat(
                String.format("/a/div//div[@title='%s']", title));
        By boardXpath = By.xpath(boardSelector);
        click(driver.findElement(boardXpath));
        return new BoardPage(driver);
    }

    @Override
    public boolean isDisplayed() {
        By iconSelector = By.xpath(baseSelector);
        WebElement icon = driver.findElement(iconSelector);
        return icon.isDisplayed();
    }
}
