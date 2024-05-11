package com.afk.driver;

import com.afk.config.ConfigFactory;
import org.openqa.selenium.WebDriver;

public final class Driver {
    private Driver() {
    }


    public static void initDriver() {
        String browser = ConfigFactory.getConfig().browser();
        if (DriverManager.getDriver() == null) {
            WebDriver driver = DriverFactory.getDriver(browser);
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();// Maximize the browser window
            DriverManager.getDriver().get(ConfigFactory.getConfig().url());// Navigate to the application URL
        }
    }

    public static void quitDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.setDriver(null);
        }
    }
}
