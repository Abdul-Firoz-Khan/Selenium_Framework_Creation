package com.afk;

import com.afk.config.ConfigFactory;
import com.afk.driver.DriverManager;
import com.afk.pages.LoginPage;
import com.afk.reports.ExtentManager;
import com.afk.utils.DataProviderUtils;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class WebSiteLoginTest extends BaseTest {

    @Test(description = "To Test the login process on a saucedemo website", dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
    public void LogonTest(String username, String password) {
        ExtentManager.getExtentTest().assignAuthor("Manu").assignCategory("Smoke").assignCategory("Regression");
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApplication(username, password);
        DriverManager.getDriver().manage().timeouts().implicitlyWait(ConfigFactory.getConfig().timeout(), TimeUnit.SECONDS);
    }
}
