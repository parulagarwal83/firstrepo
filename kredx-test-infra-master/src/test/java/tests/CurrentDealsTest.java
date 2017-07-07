package tests;

import base.BaseTest;
import listeners.TestListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CurrentDealsPage;
import pages.DashboardPage;
import pages.DealsPage;
import pages.LoginPage;

/**
 * Created by ken.dsilva on 02/07/17.
 */
@Listeners({TestListener.class})
public class CurrentDealsTest extends BaseTest {
    @Test
    public void dealPageNavigationTest(){
        driver.get(data.getUrl());

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUsername(data.getUsername())
                .enterPassword(data.getPassword())
                .submit();

        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        Assert.assertEquals(dashboardPage.isLoggedIn(),data.getLoggedInMessage());
        dashboardPage.clickOnCurrentDeals();

        CurrentDealsPage currentDealsPage = PageFactory.initElements(driver, CurrentDealsPage.class);
        currentDealsPage.clickOnSomeGoodEnterpriseShowDealButton();

        DealsPage dealsPage = PageFactory.initElements(driver, DealsPage.class);
        Assert.assertEquals(dealsPage.getDealsPageText(),data.getDealsPageText());

        dealsPage.logoutUser();
    }

    @Test
    public void dealAmountEnteredTest(){
        driver.get(data.getUrl());

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUsername(data.getUsername())
                .enterPassword(data.getPassword())
                .submit();

        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        Assert.assertEquals(dashboardPage.isLoggedIn(),data.getLoggedInMessage());
        dashboardPage.clickOnCurrentDeals();

        CurrentDealsPage currentDealsPage = PageFactory.initElements(driver, CurrentDealsPage.class);
        currentDealsPage.clickOnFivelakhsAmountButtonInDummyEnterprise();

        Assert.assertEquals(currentDealsPage.getValueOfAmountField(),data.getValueOfAmountField());
        currentDealsPage.logoutUser();
    }

    @Test
    public void dealAmountEnteredClearedTest(){
        driver.get(data.getUrl());

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUsername(data.getUsername())
                .enterPassword(data.getPassword())
                .submit();

        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        Assert.assertEquals(dashboardPage.isLoggedIn(),data.getLoggedInMessage());
        dashboardPage.clickOnCurrentDeals();

        CurrentDealsPage currentDealsPage = PageFactory.initElements(driver, CurrentDealsPage.class);
        currentDealsPage.clickOnFivelakhsAmountButtonInDummyEnterprise();
        Assert.assertEquals(currentDealsPage.getValueOfAmountField(),data.getValueOfAmountField());

        currentDealsPage.clearAmountInDummeyEnterprise();
        Assert.assertEquals(currentDealsPage.getValueOfAmountField(),data.getValueAfterClearingAmountField());
        currentDealsPage.logoutUser();
    }
}
