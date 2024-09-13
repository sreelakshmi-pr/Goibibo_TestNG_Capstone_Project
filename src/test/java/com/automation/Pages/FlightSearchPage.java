package com.automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightSearchPage extends BasePage{

    @FindBy(xpath = "//button[text()='VIEW FARES']")
    WebElement viewFareBtn;

    @FindBy(xpath = "//button[text()='UPDATE SEARCH']")
    WebElement updateSearchBtn;


    public boolean flightSearchPageIsDisplayed() {
        waitForElementToBeVisible(updateSearchBtn);
        waitForElementToBeVisible(viewFareBtn);
        return updateSearchBtn.isDisplayed() && viewFareBtn.isDisplayed();
    }
}
