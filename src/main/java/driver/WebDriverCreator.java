package driver;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverCreator {

	private static String CHROMEDRIVER_PATH = "src/main/resources/seleniumdrivers/chromedrivers/chromedriver_linux64/chromedriver";
	private static String GECKODRIVER_PATH = "src/main/resources/seleniumdrivers/firefoxdrivers/geckodriver-win64/geckodriver.exe";

	public WebDriver createDriver(String browser) {
		switch (browser) {
		case "firefox":
			if (System.getProperty("os.name").contains("Windows")) {
				GECKODRIVER_PATH = "src/main/resources/seleniumdrivers/firefoxdrivers/geckodriver-win64/geckodriver.exe";
			} else if (System.getProperty("os.name").contains("Mac")) {
				GECKODRIVER_PATH = "src/main/resources/seleniumdrivers/firefoxdrivers/geckodriver-macos/geckodriver";
			}
			System.setProperty("webdriver.gecko.driver", GECKODRIVER_PATH);
			WebDriver firefoxDriver = new FirefoxDriver();
			setDefaultSettings(firefoxDriver);
			return firefoxDriver;

		case "chrome":
			if (System.getProperty("os.name").contains("Windows")) {
				CHROMEDRIVER_PATH = "src/main/resources/seleniumdrivers/chromedrivers/chromedriver_win32/chromedriver.exe";
			} else if (System.getProperty("os.name").contains("Mac")) {
				CHROMEDRIVER_PATH = "src/main/resources/seleniumdrivers/chromedrivers/chromedriver_mac64/chromedriver";
			}
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
			WebDriver chromeDriver = new ChromeDriver(options);
			setDefaultSettings(chromeDriver);
			return chromeDriver;

		default:
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}

	private static void setDefaultSettings(WebDriver driver) {
		driver.manage().window().setSize(new Dimension(1920, 1024));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
}