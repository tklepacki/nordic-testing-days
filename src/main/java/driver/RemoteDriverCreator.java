package driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class RemoteDriverCreator {

    public RemoteWebDriver createDriver(String browser) throws MalformedURLException {
        switch (browser) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                RemoteWebDriver firefoxDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                        firefoxOptions);
                setDefaultSettings(firefoxDriver);
                return firefoxDriver;
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                RemoteWebDriver chromeDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
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