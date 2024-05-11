package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestNGExtentReportIntegration {
    ExtentReports extent;
    ExtentTest LoginTest;
    @BeforeSuite
    public void beforeSuite() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("extent.html");
        extent.attachReporter(spark);
    }

    @AfterSuite
    public void afterSuite() {
        extent.flush();
    }

    @BeforeMethod
    public void setUp(Method method) {
        LoginTest = extent.createTest(method.getName());
    }

    @Test
    public void test1() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        LoginTest.pass("URL is entered");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        LoginTest.pass("User name is entered");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        LoginTest.pass("Password is entered");
        driver.quit();
    }
    @Test
    public void test2() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        LoginTest.pass("URL is entered");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        LoginTest.pass("User name is entered");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        LoginTest.pass("Password is entered");
        LoginTest.pass("Test2 is Passed");
        driver.quit();
    }
}