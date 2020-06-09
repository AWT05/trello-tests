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
    WebDriver initBrowser() throws MalformedURLException {
        return new RemoteWebDriver(new URL(URL), setCapabilities());
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
