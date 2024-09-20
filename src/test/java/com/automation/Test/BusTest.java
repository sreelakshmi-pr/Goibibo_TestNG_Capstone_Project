package com.automation.Test;

import com.automation.Utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BusTest extends BaseTest {

    @Test
    public void searchBus() {
        homePage.openWebsite();
        busPage.clickOnBus();
        busPage.searchForBus(ConfigReader.getConfigValue("bus.from.city"),ConfigReader.getConfigValue("bus.to.city"));
        busPage.selectDate("24 September 2024");
        busPage.clickOnSearch();
        Assert.assertTrue(busPage.busSearchPageIsDisplayed());
    }

    @Test
    public void verifyLocationChangerIsWorking() {
        homePage.openWebsite();
        busPage.clickOnBus();
        busPage.searchForBus("Thrissur", "Ernakulam");
        busPage.clickOnLocationChanger();
        Assert.assertTrue(busPage.locationsInterchanged("Ernakulam", "Thrissur"));
    }

    @Test
    public void VerifyDestinationAndSourceAreNotSame() {
        homePage.openWebsite();
        busPage.clickOnBus();
        busPage.searchForBus("Thrissur", "Thrissur");
        busPage.clickOnSearch();
        Assert.assertTrue(busPage.errorMsgDisplayed());

    }

    @Test
    public void verifyRatingIsInAscendingAndDescendingOrder() {
        homePage.openWebsite();
        busPage.clickOnBus();
        busPage.searchForBus("Bangalore", "Mumbai");
        busPage.clickOnSearch();
        busPage.clickOnRating();
        Assert.assertTrue(busPage.ratingsInDescendingOder());
        busPage.clickOnRatingAscending();
        Assert.assertTrue(busPage.ratingsInAscendingOder());

    }

    @Test
    public void verifyDepartureTimeFiltering(){
        homePage.openWebsite();
        busPage.clickOnBus();
        busPage.searchForBus("Bangalore","Mumbai");
        busPage.clickOnSearch();
        busPage.clickOnDepartureAsc();
        Assert.assertTrue(busPage.departureInAscendingOrder());
        busPage.clickOnDepartureDesc();
        Assert.assertTrue(busPage.departureInDescendingOrder());
}

    @Test
    public void verifyArrivalTimeFiltering(){
        homePage.openWebsite();
        busPage.clickOnBus();
        busPage.searchForBus("Bangalore","Mumbai");
        busPage.clickOnSearch();
        busPage.clickOnArrivalAsc();
        Assert.assertTrue(busPage.arrivalInAscendingOrder());
        busPage.clickOnArrivalDesc();
        Assert.assertTrue(busPage.arrivalInDescendingOrder());
    }

    @Test
    public void VerifyTicketPriceFiltering(){
        homePage.openWebsite();
        busPage.clickOnBus();
        busPage.searchForBus("Bangalore","Mumbai");
        busPage.clickOnSearch();
        busPage.clickOnCheapestAsc();
        Assert.assertTrue(busPage.priceInAscendingOrder());
        busPage.clickOnCheapestDesc();
        Assert.assertTrue(busPage.priceInDescendingOrder());

    }
}

