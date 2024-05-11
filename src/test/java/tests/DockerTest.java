package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DockerTest {
    @Test
    public void dockerTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:8000"), capabilities);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}



