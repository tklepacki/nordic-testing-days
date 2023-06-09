package reserved.de;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driver.WebDriverCreator;
import reserved.de.testdata.UserDataProvider;
import commons.CommonTestSteps;
import pages.PageObjectManager;

public class LoginTest {

	private WebDriver driver;
	private CommonTestSteps commonTestSteps;
	private PageObjectManager manager;
	private static final String URL = "http://reserved.com/de/de";

	@Parameters
	@BeforeMethod
	public void setUp(String browser) {
		driver = new WebDriverCreator().createDriver(browser);
		commonTestSteps = new CommonTestSteps(driver);
		manager = new PageObjectManager(driver);
	}

	@Test(dataProvider = "loginTest", dataProviderClass = UserDataProvider.class)
	public void loginTest(String email, String password, String firstName) {

		commonTestSteps.loadMainPage(URL);
		driver.findElement(By.id("cookiebotDialogOkButton")).click();
		commonTestSteps.loginProcess(email, password);

		assertEquals(firstName, manager.getUserMenuPage().getAccountNameText(firstName));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}