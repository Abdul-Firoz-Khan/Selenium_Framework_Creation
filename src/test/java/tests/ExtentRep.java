package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRep {

    public static void main(String[] args) {

        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("extent.html");
        extent.attachReporter(spark);


        // Create a test with a name and description
        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
        test.assignAuthor("Manu","Sholu");
        test.assignCategory("Login").assignCategory("Smoke");
        // Log some information
        test.pass("This is a pass step");
        test.fail("This is a fail step");

        // Create another test
        ExtentTest anotherTest = extent.createTest("MySecondTest", "Another sample description");
        anotherTest.assignAuthor("Badri", "Manu");
        anotherTest.assignCategory("Home").assignCategory("Smoke").assignCategory("Regression");
        // Log some information for the second test
        anotherTest.pass("This is a pass step for the second test");
        anotherTest.warning("This is a warning step");

        // Flush the report to generate the final output
        extent.flush();
    }
}
