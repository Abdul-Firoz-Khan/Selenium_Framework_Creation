package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataProviderWithExcelSheet {
    @DataProvider(parallel = true)
    public static Object[][] getData() throws IOException {
        File file = new File(System.getProperty("user.dir") + "/testdata.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        String value = sheet.getRow(1).getCell(1).getStringCellValue();
        int lastRowNum = sheet.getLastRowNum();
        System.out.println("lastRowNum = " + lastRowNum);
        int lastCellNum = sheet.getRow(0).getLastCellNum();
        System.out.println("lastCellNum = " + lastCellNum);
        System.out.println("value = " + value);

        Object[][] a = new Object[lastRowNum][lastCellNum];

        for (int i = 1; i <= lastRowNum; i++) {
            for (int j = 0; j < lastCellNum; j++) {
               a[i-1][j] =sheet.getRow(i).getCell(j).getStringCellValue();

            }

        }
        return a;
    }



    @Test(dataProvider = "getData")
    public void DataProviderTest(String username, String password) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(3000);
        driver.quit();
    }

}
