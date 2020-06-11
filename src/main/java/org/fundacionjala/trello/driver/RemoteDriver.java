package org.fundacionjala.trello.driver;

import org.fundacionjala.core.RemoteServerEnv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public final class RemoteDriver extends AbstractBrowser {

    private static final String URL = RemoteServerEnv.getInstance().getRemoteServerURL();

    @Override
    WebDriver initBrowser() {
        RemoteWebDriver remote = null;
        try {
            remote = new RemoteWebDriver(new URL(URL), setCapabilities());
        } catch (MalformedURLException e) {
            String message = String.format("Error: <%s> Not found, or malformed URL", URL);
            throw new RuntimeException(message.concat(e.getMessage()));
        }
        return remote;
    }

    private DesiredCapabilities setCapabilities() {
        Map<String, String> capsData = RemoteServerEnv.getInstance().getCapabilities();
        Map<String, String> envData = RemoteServerEnv.getInstance().getRemoteEnvironments();
        DesiredCapabilities caps = new DesiredCapabilities();
        capsData.forEach(caps::setCapability);
        envData.forEach(caps::setCapability);
        return caps;
    }
}
