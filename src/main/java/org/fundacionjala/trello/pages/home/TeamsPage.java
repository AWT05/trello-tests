package org.fundacionjala.trello.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class TeamsPage extends HomePage {

    private static final String SETTINGS_BUTTON = "//h3[text()='%s']/parent::div/parent::div";

    public TeamsPage(final WebDriver driver) {
        super(driver);
    }

    public WebElement getSettingsButton(final String teamName) {
        return driver.findElement(By.xpath(String.format(SETTINGS_BUTTON, teamName)));
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
