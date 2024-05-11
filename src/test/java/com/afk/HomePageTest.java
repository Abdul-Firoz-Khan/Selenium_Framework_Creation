package com.afk;

import com.afk.config.ConfigFactory;
import com.afk.driver.DriverManager;
import com.afk.pages.LoginPage;
import com.afk.utils.DataProviderUtils;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class HomePageTest extends BaseTest {

    @Test(description ="To check whether the title of saucedemo website homepage is displayed correctly"
            ,dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void HomePageTest(String username, String password, String expectedTitle) {
        // Test logic using username, password, and expectedTitle


        LoginPage loginPage = new LoginPage();
        String actualTitle=loginPage.loginToApplication(username,password)
                .getHomePageTitle();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(ConfigFactory.getConfig().timeout(), TimeUnit.SECONDS);
        System.out.println("Actual title: " + actualTitle); //
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}