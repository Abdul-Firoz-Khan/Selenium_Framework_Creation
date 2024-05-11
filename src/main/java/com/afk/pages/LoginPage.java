package com.afk.pages;

import com.afk.driver.DriverManager;
import com.afk.reports.ExtentLogger;
import com.afk.reports.ExtentManager;
import com.afk.utils.SeleniumUtils;
import org.openqa.selenium.By;

import static com.afk.utils.SeleniumUtils.*;

public class LoginPage {
    private static final By TXTBOX_USERNAME = By.id("user-name");
    private final static By TXTBOX_PASSWORD = By.id("password");
    private final static By BTN_LOGIN = By.id("login-button");

    private LoginPage setUserName(String username) {

        sendKeys(TXTBOX_USERNAME, username,"Username");

        return this;
    }

    private LoginPage setPassword(String password) {

        sendKeys(TXTBOX_PASSWORD, password,"Password");

        return this;
    }

    private HomePage setLogin() {
        click(BTN_LOGIN,"Login Button");

        return new HomePage();
    }

    public HomePage loginToApplication(String username, String password) {
        return setUserName(username).setPassword(password).setLogin();
    }
}
