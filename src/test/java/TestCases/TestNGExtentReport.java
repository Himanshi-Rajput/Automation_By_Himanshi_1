package TestCases;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;


public class TestNGExtentReport {

    static ExtentReports reports;
    static ExtentTest test;

    @BeforeSuite
    public  static void startReport()
    {
         reports = new ExtentReports(System.getProperty("user.dir")+"/test-output/All Test Suite/MyOwnReport.html", true);
         reports.addSystemInfo("Host Name" , "Local Host");
         reports.addSystemInfo("Environment", "QA");
         reports.addSystemInfo("User Name", "Himanshi");
         reports.loadConfig(new File(System.getProperty("user.dir")+"/test-output/extent-config.xml"));
    }


    @AfterMethod
    public static void getResult(ITestResult Result)
    {
        if(Result.getStatus() == ITestResult.FAILURE)
        {
            test.log(LogStatus.FAIL , Result.getThrowable());
        }
        else if (Result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(LogStatus.PASS, Result.getTestName());
        }
        else
        {
            test.log(LogStatus.SKIP , Result.getTestName());
        }

        reports.endTest(test);
    }

    @AfterSuite
    public static void endtest()
    {
        reports.flush();
    }
}
