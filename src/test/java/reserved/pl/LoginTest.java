package reserved.pl;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driver.WebDriverCreator;
import reserved.pl.testdata.UserDataProvider;
import commons.CommonTestSteps;
import pages.PageObjectManager;

public class LoginTest {

	private WebDriver driver;
	private CommonTestSteps commonTestSteps;
	private PageObjectManager manager;
	private static final String URL = "http://reserved.com/pl/pl";

	@BeforeMethod
	public void setUp() {
		driver = new WebDriverCreator().createDriver("firefox");
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