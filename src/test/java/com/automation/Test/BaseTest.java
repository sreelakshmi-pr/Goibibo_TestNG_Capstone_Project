package com.automation.Test;

import com.automation.Pages.*;
import com.automation.Utils.AllureReportManager;
import com.automation.Utils.ConfigReader;
import com.automation.Utils.DriverManager;
import com.automation.Utils.ExtentReportManager;
import com.aventstack.extentreports.gherkin.model.Scenario;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    HomePage homePage;
    HotelPage hotelPage;
    FlightPage flightPage;
    FlightSearchPage flightSearchPage;
    BusPage busPage;

    @BeforeMethod
    public void setUp(){
        DriverManager.createDriver();
        ConfigReader.initConfig();
        homePage=new HomePage();
        hotelPage=new HotelPage();
        flightPage=new FlightPage();
        flightSearchPage=new FlightSearchPage();
        busPage=new BusPage();


    }
    @AfterMethod
    public void cleanUp(){
        DriverManager.getDriver().quit();

    }
    }


