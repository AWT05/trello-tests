package org.fundacionjala.trello.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class TeamsPage extends HomePage {

    public TeamsPage(final WebDriver driver) {
        super(driver);
    }

    public WebElement getSettingsButton(final String teamName) {
        return driver.findElement(By.xpath(String.format("//h3[text()='%s']/parent::div/parent::div", teamName)));
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
