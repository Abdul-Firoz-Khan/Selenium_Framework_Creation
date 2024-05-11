package com.afk.utils;

import com.afk.config.ConfigFactory;
import com.afk.driver.DriverManager;
import com.afk.reports.ExtentLogger;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
    public static void click(By by,String elementName){
        WebElement element = waitUntilElementIsPresent(by);
        element.click();
        ExtentLogger.info(elementName+ " is clicked successfully");
    }
    public static void sendKeys(By by,String value,String elementName){
        WebElement element= waitUntilElementIsPresent(by);
        element.sendKeys(value);
        ExtentLogger.info(value+ " is filled successfully in " + elementName);
    }
    public static WebElement waitUntilElementIsPresent(By by){
        WebDriverWait wait= new WebDriverWait(DriverManager.getDriver(), ConfigFactory.getConfig().timeout());
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
