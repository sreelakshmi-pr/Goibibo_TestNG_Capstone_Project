package com.automation.Utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class AllureReportManager {

    @Attachment(type="image/png",value = "screenshot")
    public static void attachScreenshot(){
        TakesScreenshot ts=(TakesScreenshot) DriverManager.getDriver();
        byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot",new ByteArrayInputStream(screenshot));
    }

    @Attachment(type = "text/plain")
    public static void attachLog(String message) {
        Allure.addAttachment("Log", message);
//        Allure.step(message);
    }
}
