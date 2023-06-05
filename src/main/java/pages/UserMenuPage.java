package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CustomFluentWait;
import utils.Wait;

public class UserMenuPage {

    @FindBy(xpath = "//div[@data-testid='account-info-logged-false'] | //div[@id='headerWrapper']/div/div[3]/div[2] | /html/body/div[2]/div/div[2]/div/div[1]/div[3]/div[1]/div[1]/a")
    private WebElement accountIconLoggedOut;

    @FindBy(xpath = "//div[@data-testid='account-info-logged-true'] | /html/body/div[1]/div/div[2]/div/div[1]/div[3]/div[1]/div[1]/a")

    private WebElement accountIconLoggedIn;

    private CustomFluentWait customFluentWait;

    public UserMenuPage(WebDriver driver) {
        customFluentWait = new CustomFluentWait(driver);
    }

    public void clickAccountLoginIcon() {
        customFluentWait.clickElement(accountIconLoggedOut);
    }

    public String getAccountNameText() {
        Wait.waitForThreeSeconds();
        customFluentWait.waitForElementDisplayed(accountIconLoggedIn);
		return accountIconLoggedIn.getText();
    }
}