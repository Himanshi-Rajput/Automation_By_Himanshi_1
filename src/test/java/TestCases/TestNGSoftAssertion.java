package TestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGSoftAssertion extends TestNGExtentReport {

    static SoftAssert softAssert = new SoftAssert();

    @Test(enabled = false)
    public static void demo1()
    {
        test = reports.startTest("TestCase1", "Failed Testcase");
        softAssert.assertEquals("welcome", "welecome");
        softAssert.assertAll();
    }

    @Test
    public static void  demo2() throws InterruptedException {
        Thread.sleep(4000);
        test = reports.startTest("TestCase2", "Passed Testcase");
        softAssert.assertEquals("welcome" , "welcome");
        softAssert.assertAll();
    }
    @Test(enabled = false)
    public static void demo3() throws InterruptedException {
        Thread.sleep(3000);
        test = reports.startTest("TestCase3", "Failed Testcase");
        softAssert.assertTrue(true);
        softAssert.assertEquals("Himanshi" , "himanshi");
        softAssert.assertEquals("Selenium", "Selenium");
        System.out.println("Method 3rd");
        softAssert.assertAll();
    }

    public static void main(String[] args) throws InterruptedException  {


        demo1();
        demo2();
        demo3();
    }




}
