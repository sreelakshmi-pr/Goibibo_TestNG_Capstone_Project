package com.automation.Test;

import com.automation.Utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelTest extends BaseTest{

    @Test
    public void searchHotel(){
        homePage.openWebsite();
        hotelPage.clickOnHotel();
        hotelPage.enterLocation(ConfigReader.getConfigValue("hotel.city"));
        hotelPage.selectCheckInDate(ConfigReader.getConfigValue("hotel.checkInDate"));
        hotelPage.selectCheckOutDate(ConfigReader.getConfigValue("hotel.checkOutDate"));
        hotelPage.selectNumberOfGuestsAndNumberOfRooms("2","4","1","2");
        hotelPage.clickOnSearch();
        Assert.assertTrue(hotelPage.hotelSearchPageIsDisplayed());
    }

    @Test
    public void bookTheFirstHotel(){
        homePage.openWebsite();
        hotelPage.clickOnHotel();
        hotelPage.enterLocation(ConfigReader.getConfigValue("hotel.city"));
        hotelPage.selectCheckInDate(ConfigReader.getConfigValue("hotel.checkInDate"));
        hotelPage.selectCheckOutDate(ConfigReader.getConfigValue("hotel.checkOutDate"));
        hotelPage.clickOnSearch();
        hotelPage.clickOnFirstHotel();
        hotelPage.clickOnSelectRoomBtn();
        Assert.assertTrue(hotelPage.propertyInfoPageIsDisplayed());
        hotelPage.fillDetails();
        hotelPage.proceedToPayment();
        Assert.assertTrue(hotelPage.paymentPageIsDisplayed());
    }

    @Test
    public void priceOfHotelsAreInLowToHighOrder(){
        homePage.openWebsite();
        hotelPage.clickOnHotel();
        hotelPage.enterLocation(ConfigReader.getConfigValue("hotel.city"));
        hotelPage.selectCheckInDate(ConfigReader.getConfigValue("hotel.checkInDate"));
        hotelPage.selectCheckOutDate(ConfigReader.getConfigValue("hotel.checkOutDate"));
        hotelPage.clickOnSearch();
        Assert.assertTrue(hotelPage.hotelSearchPageIsDisplayed());
        hotelPage.clickOnPriceLowToHigh();
        Assert.assertTrue(hotelPage.priceIsLowToHighOrder());

    }

    @Test
    public void priceOfHotelsAreInHighToLowOrder(){
        homePage.openWebsite();
        hotelPage.clickOnHotel();
        hotelPage.enterLocation(ConfigReader.getConfigValue("hotel.city"));
        hotelPage.selectCheckInDate(ConfigReader.getConfigValue("hotel.checkInDate"));
        hotelPage.selectCheckOutDate(ConfigReader.getConfigValue("hotel.checkOutDate"));
        hotelPage.clickOnSearch();
        Assert.assertTrue(hotelPage.hotelSearchPageIsDisplayed());
        hotelPage.clickOnPriceHighToLow();
        Assert.assertTrue(hotelPage.priceIsHighToLowOrder());

    }

    //website error
    @Test
    public void customerRatingsAreInDescendingOrder(){
        homePage.openWebsite();
        hotelPage.clickOnHotel();
        hotelPage.enterLocation(ConfigReader.getConfigValue("hotel.city"));
        hotelPage.selectCheckInDate(ConfigReader.getConfigValue("hotel.checkInDate"));
        hotelPage.selectCheckOutDate(ConfigReader.getConfigValue("hotel.checkOutDate"));
        hotelPage.clickOnSearch();
        Assert.assertTrue(hotelPage.hotelSearchPageIsDisplayed());
        hotelPage.clickOnCustomerRating();
        Assert.assertTrue(hotelPage.hotelsInDescendingOrderByCustomerRating());

    }
}
