package com.afk.utils;

import com.afk.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenshotUtils {
   private ScreenshotUtils(){}
    public static String getScreenshot(){
        //return ((TakesScreenshot) DriverManager.getDriver().getScreenShotAs(OutputType.BASE64));
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

    }
}
