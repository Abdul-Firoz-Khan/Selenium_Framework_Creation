package com.afk;

import com.afk.driver.Driver;
import com.afk.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class BaseTest {


    @BeforeMethod
    public void setup() { Driver.initDriver();
    }
    @AfterMethod
    public void tearDown() { Driver.quitDriver();
    }
}
