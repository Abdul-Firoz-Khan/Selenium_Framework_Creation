package com.afk;

import com.afk.testdata.TestData;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.TestDataReader;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;
import org.testng.annotations.Test;


public class DataSupplierTest {
    @Test(dataProvider = "getData")testdata
    public void dataSupplierTest(TestData testData){
        System.out.println(testData.username);

    }
    @DataSupplier
    public StreamEx<TestData> getData(){
return TestDataReader.use(XlsxReader.class)
        .withTarget(TestData.class)
        .withSource("C:/Users/lenovo/Documents/E/Testing/selenium-project/maven_project/MavenTest/src/test/resources/testdata.xlsx")
        .read();
    }
}
