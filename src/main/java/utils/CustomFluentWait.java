package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomFluentWait {
	private WebDriver driver;
	private FluentWaitFactory waitFactory;
	private ExpectedEvents expectedEvents;

	public CustomFluentWait(WebDriver driver) {
		this.driver = driver;
		waitFactory = new FluentWaitFactory(driver);
		expectedEvents = new ExpectedEvents(driver, this.getClass().getName());
	}

	public boolean isElementPresent(final WebElement element) {
		try {
			waitForElementDisplayed(element);
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	private void waitForElementBeingClickable(final By locator) {
		waitFactory.getCustomWait().until(expectedEvents.elementToBeClickable(locator));
	}

	public void waitForElementDisplayed(final WebElement element, final Duration timeoutInSeconds) {
		waitFactory.getCustomWait(timeoutInSeconds).until(expectedEvents.elementIsPresent(element));
	}

	public void waitForElementDisplayed(final WebElement element) {
		waitFactory.getCustomWait().until(expectedEvents.elementIsPresent(element));
	}

	public void moveToElementUntilTargetIsDisplayed(final WebElement moveToElement,
			WebElement targetToBeDisplayedAfterMove, final Duration timeoutInSeconds) {
		waitFactory.getCustomWait(timeoutInSeconds)
				.until(expectedEvents.moveToElementAndDisplayTarget(moveToElement, targetToBeDisplayedAfterMove));
	}

	public void clickElement(final WebElement element) {
		waitForAccountIcon();
		Wait.waitForOneSecond();
		waitFactory.getCustomWait().until(expectedEvents.clickElement(element));
	}

	public void clickElement(final WebElement element, final Duration timeoutInSeconds) {
		waitForAccountIcon();
		Wait.waitForOneSecond();
		waitFactory.getCustomWait(timeoutInSeconds).until(expectedEvents.clickElement(element));
	}

	public String getElementText(final WebElement element, final Duration timeoutInSeconds) {
		return waitFactory.getCustomWait(timeoutInSeconds).until(expectedEvents.getElementText(element));
	}

	private void waitForAccountIcon() {
		String url = driver.getCurrentUrl();
		String accountIconXpath = "Wrong url!";
		accountIconXpath = "//div[@data-testid='account-info-logged-false' or @data-testid='account-info-logged-true']";

		if (!accountIconXpath.equals("Wrong url!")) {
			waitForElementBeingClickable(By.xpath(accountIconXpath));
		}
	}

}