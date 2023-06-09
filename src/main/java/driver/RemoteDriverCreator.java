package driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RemoteDriverCreator {

    public RemoteWebDriver createDriver(String browser) throws MalformedURLException {
        switch (browser) {
            case "firefox":
                DesiredCapabilities firefoxCapabilities = new DesiredCapabilities();
                firefoxCapabilities.setCapability("browserName", "firefox");
                firefoxCapabilities.setCapability("browserVersion", "112.0");
                Map firefoxOptions = new HashMap<>();
                firefoxOptions.put("enableVNC", true);
                firefoxCapabilities.setCapability("selenoid:options", firefoxOptions);
                RemoteWebDriver firefoxDriver = new RemoteWebDriver(
                        URI.create("http://localhost:4444/wd/hub").toURL(),
                        firefoxCapabilities);
                setDefaultSettings(firefoxDriver);
                return firefoxDriver;
            case "chrome":
                DesiredCapabilities chromeCapabilities = new DesiredCapabilities();
                chromeCapabilities.setCapability("browserName", "chrome");
                chromeCapabilities.setCapability("browserVersion", "112.0");
                Map chromeOptions = new HashMap<>();
                chromeOptions.put("enableVNC", true);
                chromeCapabilities.setCapability("selenoid:options", chromeOptions);
                RemoteWebDriver chromeDriver = new RemoteWebDriver(
                        URI.create("http://localhost:4444/wd/hub").toURL(),
                        chromeCapabilities);
                setDefaultSettings(chromeDriver);
                return chromeDriver;
            default:
                throw new IllegalArgumentException("The Browser Type is Undefined");
        }
    }

    private static void setDefaultSettings(WebDriver driver) {
        driver.manage().window().setSize(new Dimension(1920, 1024));
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
    }

}