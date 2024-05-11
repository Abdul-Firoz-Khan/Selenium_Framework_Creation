package com.afk.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

public class  DataProviderUtils {
    @DataProvider(parallel = true)
    public static Object[][] getData() throws IOException {
        String filePath = "C:/Users/lenovo/Documents/E/Testing/selenium-project/maven_project/MavenTest/src/test/resources/testdata.xlsx"; // Update with your file path
        FileInputStream inputStream = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(1); // Assuming data is in the 2nd sheet
        int rowCount = sheet.getLastRowNum();
        Object[][] data = new Object[rowCount][3]; // 3 columns: username, password, expected title
        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i + 1); // Skip header row
            for (int j = 0; j < 3; j++) { // Assuming 3 columns
                Cell cell = row.getCell(j);
                data[i][j] = cell.getStringCellValue();
            }
        }
        workbook.close();
        inputStream.close();
        return data;
    }
}


