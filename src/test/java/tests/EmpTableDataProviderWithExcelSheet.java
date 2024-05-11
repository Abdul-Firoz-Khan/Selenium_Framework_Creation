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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EmpTableDataProviderWithExcelSheet {
    @DataProvider(parallel = true)
    public static Object[][] getData() throws IOException, IOException {
        File file = new File(System.getProperty("user.dir") + "/testdata.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int lastRowNum = sheet.getLastRowNum();
        System.out.println("lastRowNum = " + lastRowNum);
        int lastCellNum = sheet.getRow(0).getLastCellNum();
        System.out.println("lastCellNum = " + lastCellNum);

        Object[][] a = new Object[lastRowNum][1];

        for (int i = 1; i <= lastRowNum; i++) {
            Map<String, String> map = new HashMap<>();
            for (int j = 0; j < lastCellNum; j++) {
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value1 = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key, value1);
            }
            a[i - 1][0] = map;
        }
        return a;
    }

    @Test(dataProvider = "getData")
    public void DataProviderTest(Map<String,String> data) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();

        driver.findElement(By.id("user-name")).sendKeys(data.get("username"));
        driver.findElement(By.id("password")).sendKeys(data.get("password"));
        Thread.sleep(3000);
        driver.quit();
    }
}
