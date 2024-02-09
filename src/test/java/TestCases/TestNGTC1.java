package TestCases;

import org.testng.annotations.Test;

public class TestNGTC1 extends TestNGExtentReport {

    @Test(priority = 1)
    void setup()
    {
        test = reports.startTest("Test Case 10" , "Simple Test");
        System.out.println("Complete Browser setting");
    }

    @Test (priority = 2)
    void  login()
    {
        test = reports.startTest("Test Case 11" , "Simple Test");
        System.out.println("Login Test");
    }

    @Test (priority = 3)
    void close()
    {
        test = reports.startTest("Test Case 12" , "Simple Test");
        System.out.println("Closing Browser");
    }
}
