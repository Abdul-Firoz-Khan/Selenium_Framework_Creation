package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstProject {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Swag Labs";
        if (actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Test is passed");
        }
        else {
            System.out.println("Test is Failed");
        }

        //Swag Labs


//        Thread.sleep(3000);
//        WebElement element = driver.findElement(By.xpath("//div[text()='Products']/following-sibling::*"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).build().perform();
//        actions.click(element).build().perform();

//    Actions actions=new Actions(driver);
//    actions.moveToElement((WebElement) elementList).build().perform();
//    actions.click((WebElement) elementList).build().perform();
        //div[text()='Products']/following-sibling::*/option
//    List<WebElement> nameAtoZ = driver.findElements(By.xpath("//div[text()='Products']/following-sibling::*/option"));
//    actions.moveToElement((WebElement) nameAtoZ).build().perform();


        //Thread.sleep(5000);

    }
}
