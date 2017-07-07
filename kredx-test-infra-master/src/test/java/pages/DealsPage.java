package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by ken.dsilva on 02/07/17.
 */
public class DealsPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Invoice raised for')]")
    WebElement onDealsPageText;

    @FindBy(xpath = "//div[@class='name']/span")
    WebElement clickOnProfileDropdown;

    @FindBy(xpath = "//li[contains(text(),'LOG OUT')]")
    WebElement logoutButton;

    public DealsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Return text on Deals Page")
    public String getDealsPageText(){
        waitForElement(onDealsPageText);
        return onDealsPageText.getText();
    }

    @Step("Logout of Deals Page")
    public void logoutUser(){
        waitForElementToBeClickable(clickOnProfileDropdown);
        clickOnProfileDropdown.click();
        logoutButton.click();
    }
}
