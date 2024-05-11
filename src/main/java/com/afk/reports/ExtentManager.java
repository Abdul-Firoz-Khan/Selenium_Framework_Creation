package com.afk.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
    private ExtentManager(){}

    private static final ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();
    public static ExtentTest getExtentTest(){
        return threadLocal.get();
    }
     static ExtentTest setExtentTest(ExtentTest test){
        threadLocal.set(test);
        return test;
    }

}
