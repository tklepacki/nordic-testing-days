package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CustomFluentWait;

public class UserMenuPage {

    @FindBy(xpath = "//div[@data-testid='account-info-logged-false']")
    private WebElement accountIconLoggedOut;

    @FindBy(xpath = "//div[@data-testid='account-info-logged-true']")
    private WebElement accountIconLoggedIn;

    private CustomFluentWait customFluentWait;

    public UserMenuPage(WebDriver driver) {
        customFluentWait = new CustomFluentWait(driver);
    }

    public void clickAccountLoginIcon() {
        customFluentWait.clickElement(accountIconLoggedOut);
    }

    public String getAccountNameText() {
        customFluentWait.waitForElementDisplayed(accountIconLoggedIn);
		return accountIconLoggedIn.getText();
    }
}