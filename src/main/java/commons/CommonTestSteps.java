package commons;

import org.openqa.selenium.WebDriver;

import pages.PageObjectManager;

public class CommonTestSteps {

	private final WebDriver driver;
	private final PageObjectManager manager;

	public CommonTestSteps(WebDriver driver) {
		this.driver = driver;
		manager = new PageObjectManager(driver);
	}

	public void loadMainPage(String url) {
		driver.navigate().to(url);
	}

	public void loginProcess(String email, String password) {
		manager.getUserMenuPage().clickAccountLoginIcon();
		manager.getLoginPage().sendLogin(email);
		manager.getLoginPage().sendPassword(password);
		manager.getLoginPage().clickLoginBtn();
	}

}