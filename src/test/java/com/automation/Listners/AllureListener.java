package com.automation.Listners;

import io.qameta.allure.testng.AllureTestNg;
import org.testng.ITestResult;
import com.automation.Utils.AllureReportManager;

public class AllureListener extends AllureTestNg {

    @Override
    public void onTestFailure(ITestResult result) {
        AllureReportManager.attachScreenshot();
        AllureReportManager.attachLog("Test got failed");
        super.onTestFailure(result);
    }
}
