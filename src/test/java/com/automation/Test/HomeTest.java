package com.automation.Test;

import com.automation.Utils.AllureReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomeTest extends BaseTest{

    @Test
    public void userLogin() throws IOException {
        homePage.openWebsite();
        AllureReportManager.attachLog("Home Page");
        AllureReportManager.attachScreenshot();
        Assert.assertTrue(homePage.isInHomePage());
    }
//
//    @Test
//    public void userRegistration(){
//        homePage.openWebsite();
//        homePage.userRegister();
//        ExtentReportManager.attachScreenShot();
//        AllureReportManager.attachLog("failed");
//        AllureReportManager.attachScreenshot();
//        Assert.assertTrue(homePage.is);
//        ExtentReportManager.getTest().fail()
//    }




}
