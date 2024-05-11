package com.afk.pages;

import com.afk.driver.DriverManager;

public class HomePage {
    public String getHomePageTitle(){
        return DriverManager.getDriver().getTitle();
    }
}
