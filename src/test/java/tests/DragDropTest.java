package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
        Actions actions= new Actions(driver);

     driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(draggable,droppable).build().perform();
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='Resizable']")).click();
        //actions.clickAndHold(draggable).moveToElement(droppable).release().build().perform();

        Thread.sleep(2009);
        driver.close();




    }
}
