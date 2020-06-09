package org.fundacionjala.trello.driver;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public abstract class AbstractBrowser {

    abstract WebDriver initBrowser() throws MalformedURLException;
}
