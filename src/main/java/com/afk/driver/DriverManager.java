package com.afk.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private DriverManager(){}
    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();
    public static WebDriver getDriver(){
        return threadLocal.get();
    }
    public static WebDriver setDriver(WebDriver driver){
        threadLocal.set(driver);
        return driver;
    }
}
