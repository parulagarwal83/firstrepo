package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by ken.dsilva on 09/06/17.
 */
public class CurrentDealsPage extends BasePage {

    @FindBy(xpath = "//div[div[div[div[h5[contains(text(),'Sv Industries 2')]]]]]/div[3]/div/div[2]/div/div/div/input")
    WebElement svIndustriesDealAmount;

    @FindBy(xpath = "//div[div[div[div[h5[contains(text(),'Some Good Enterprise')]]]]]/div[3]/div/div[2]/div/div/div/input")
    WebElement someGoodEnterpriseDealAmount;

    @FindBy(xpath = "//div[div[div[div[h5[contains(text(),'Sv Industries 2')]]]]]/div[3]/div/div[2]/div[2]/div/button")
    WebElement svIndustriesBuyNowButton;

    @FindBy(xpath = "//div[div[div[div[h5[contains(text(),'Some Good Enterprise')]]]]]/div[3]/div/div[2]/div[2]/div/button")
    WebElement someGoodEnterpriseBuyNowButton;

    @FindBy(xpath = "//div[div[div[h5[contains(text(),'Sv Industries 2')]]]]/div[2]/a/button")
    WebElement svIndustriesShowDealsButton;

    @FindBy(xpath = "//button[contains(text(),'Buy Now')]")
    WebElement onCurrentDealsPageText;

    @FindBy(xpath = "//strong[contains(text(),'Transaction Successful')]")
    WebElement transactionSuccessfulText;

    @FindBy(xpath = "//div[@class='name']/span")
    WebElement clickOnProfileDropdown;

    @FindBy(xpath = "//li[contains(text(),'LOG OUT')]")
    WebElement logoutButton;

    @FindBy(xpath = ".//span[contains(text(),'Continue Investing')]")
    WebElement continueInvestingButton;

    @FindBy(xpath = "//div[@class = 'header-balance']")
    WebElement headerBalanceText;

    @FindBy(xpath = "//span[contains(text(),'Not Enough Balance')]")
    WebElement insufficientAmountText;

    @FindBy(xpath = "//div[div[div[h5[contains(text(),'Some Good Enterprise')]]]]/div[2]/a/button")
    WebElement someGoodEnterpriseShowDealButton;

    @FindBy(xpath = "//div[div[div[div[h5[contains(text(),'Dummy Enterprise')]]]]]/div[3]/div/div/div[2]/div/div//button[span[span[span[contains(text(),'5')]]]]")
    WebElement fiveLacsDummyEnterpriseAmountButton;

    @FindBy(xpath = "//div[div[div[div[h5[contains(text(),'Dummy Enterprise')]]]]]/div[3]/div/div[2]/div/div/div/input")
    WebElement amountFieldInDummyEnterprise;

    @FindBy(xpath = "//div[div[div[div[h5[contains(text(),'Dummy Enterprise')]]]]]/div[3]/div/div[2]/div/div/div/div[2]")
    WebElement clearAmountFieldInDummyEnterprise;

    public CurrentDealsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify on Current Deals page")
    public String verifyOnCurrentDealsPage(){
        waitForElement(onCurrentDealsPageText);
        return onCurrentDealsPageText.getText();
    }

    @Step("Enter deal amount for Sv Industries Deal")
    public CurrentDealsPage inputDealAmount(String amount){
        writeTextInField(svIndustriesDealAmount,amount);
        return this;
    }

    @Step("Enter deal amount for some Good Enterprise Deal")
    public CurrentDealsPage inputOverBalanceLimitAmount(String amount){
        writeTextInField(someGoodEnterpriseDealAmount,amount);
        return this;
    }

    @Step("Click on Buy now for Sv Industries")
    public void clickOnBuyNowButton(){
        clickOnElement(svIndustriesBuyNowButton);
    }

    @Step("Click on Buy now for Some Good Enterprise")
    public void clickOnSomeGoodEnterpriseBuyNow(String dealName){
        WebElement webElement = findElement("xpath","//div[div[div[div[h5[contains(text(),'%')]]]]]/div[3]/div/div[2]/div[2]/div/button", dealName);
        clickOnElement(webElement);
    }

    @Step("Successful deal confirmation")
    public String getDealConfirmationMessage(){
        waitForElement(transactionSuccessfulText);
        return transactionSuccessfulText.getText();
    }

    @Step("User logged out")
    public CurrentDealsPage logoutUser(){
        waitForElementToBeClickable(clickOnProfileDropdown);
        clickOnProfileDropdown.click();
        logoutButton.click();
        return this;
    }

    @Step("Click on continue investing page")
    public CurrentDealsPage clickOnContinueInvestingButton(){
        clickOnElement(continueInvestingButton);
        return this;
    }

    @Step("Retrieving insufficient balance amount message")
    public String getInsufficientBalanceMessage() {
        waitForElement(insufficientAmountText);
        return insufficientAmountText.getText();
    }

    @Step("Click on Some Good Enterprise show deal button")
    public void clickOnSomeGoodEnterpriseShowDealButton(){
        clickOnElement(someGoodEnterpriseShowDealButton);
    }

    @Step("Click on '5 lacs' amount button in Dummy Enterprise")
    public CurrentDealsPage clickOnFivelakhsAmountButtonInDummyEnterprise(){
        clickOnElement(fiveLacsDummyEnterpriseAmountButton);
        return this;
    }

    @Step("Retrieve value in amount Field")
    public String getValueOfAmountField(){
        waitForElement(amountFieldInDummyEnterprise);
        return amountFieldInDummyEnterprise.getAttribute("value");
    }

    @Step("Clear amount field in Dummy Enterprise")
    public CurrentDealsPage clearAmountInDummeyEnterprise(){
        clickOnElement(clearAmountFieldInDummyEnterprise);
        return this;
    }
}
