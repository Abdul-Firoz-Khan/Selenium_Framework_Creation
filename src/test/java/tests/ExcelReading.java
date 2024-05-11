package tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReading {
    public static void main(String[] args) throws IOException {

        File file = new File(System.getProperty("user.dir") + "/testdata.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        String testCaseName = "titleValidationTest"; // Test case name to match

        int lastRowNum = sheet.getLastRowNum();
        System.out.println("lastRowNum = " + lastRowNum);
        int lastCellNum = sheet.getRow(0).getLastCellNum();
        System.out.println("lastCellNum = " + lastCellNum);

        for (int i = 1; i <= lastRowNum; i++) { // Starting from 1 to skip header row
            String currentTestCaseName = sheet.getRow(i).getCell(0).getStringCellValue();
            if (currentTestCaseName.equals(testCaseName)) {
                String username = sheet.getRow(i).getCell(1).getStringCellValue();
                String password = sheet.getRow(i).getCell(2).getStringCellValue();
                String expectedTitle = sheet.getRow(i).getCell(3).getStringCellValue();
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                System.out.println("Expected Title: " + expectedTitle);
                // If you only want to print the first match, you can break here
                // break;
            }
        }

        workbook.close();
        inputStream.close();
    }
}
