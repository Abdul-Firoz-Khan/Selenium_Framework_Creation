package tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PrintCountriesAndCapital {
    public static void main(String[] args) throws IOException {

        File file = new File(System.getProperty("user.dir")+"/testdata.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook= new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet2");
        String value = sheet.getRow(1).getCell(1).getStringCellValue();
        int lastRowNum = sheet.getLastRowNum();
        System.out.println("lastRowNum = " + lastRowNum);
        int lastCellNum = sheet.getRow(0).getLastCellNum();
        System.out.println("lastCellNum = " + lastCellNum);
        System.out.println("value = " + value);


        for (int i = 1; i <= lastRowNum ; i++) {
            for (int j = 0; j < lastCellNum; j++) {
                System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());

            }

        }
    }
}
