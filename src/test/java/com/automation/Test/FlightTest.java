package com.automation.Test;

import com.automation.Utils.ConfigReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightTest extends BaseTest{

    @Test
    public void verifyUserIsOnFlightSearchPage() {
        homePage.openWebsite();
        flightPage.searchForFlight(ConfigReader.getConfigValue("flight.from.city"),ConfigReader.getConfigValue("flight.to.city"));
        flightPage.selectDepartureDate(ConfigReader.getConfigValue("flight.departure.time"));
        flightPage.clickOnSearchBtn();
        Assert.assertTrue(flightSearchPage.flightSearchPageIsDisplayed());
    }

    @Test
    public void error_message_should_be_displayed_for_same_location() {

        homePage.openWebsite();
        flightPage.searchForFlight("Mumbai","Mumbai");
        flightPage.clickOnSearchBtn();
        Assert.assertEquals(flightPage.errorMessageIsDisplayed(),"source and destination cannot be same");
    }

    @Test
    public void verifyRoundTripIsSelected() {
        homePage.openWebsite();
        flightPage.clickOnRoundTrip();
        Assert.assertTrue(flightPage.returnDateIsDisplayed());

    }

    @Test
    public void verifyMultiCityIsSelected() {
        homePage.openWebsite();
        flightPage.clickOnMultiCity();
        Assert.assertTrue(flightPage.addAnotherFlightButtonIsDisplayed());

    }



}
