package TestCases;

import jdk.jfr.Enabled;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGSoftAssertion3 extends TestNGExtentReport {

    static SoftAssert softAssert = new SoftAssert();
//    static SoftAssert softAssert2 = new SoftAssert();
//    static SoftAssert softAssert3 = new SoftAssert();

    @Test
    public static void demo3() {
        test = reports.startTest("TestCase4", "Failed Testcase");
        softAssert.assertTrue(true);
        softAssert.assertEquals("Himanshi", "himanshi");
        softAssert.assertEquals("Selenium", "Selenium");
        System.out.println("Method 3rd");
        softAssert.assertAll();
    }

    @Test
    public static void demo2() {
        test = reports.startTest("TestCase5", "Passed Testcase");
        softAssert.assertEquals("welcome", "welcome");
        softAssert.assertAll();
    }

    @Test
    public static void demo1() {
        test = reports.startTest("TestCase6", "Failed Testcase");
        softAssert.assertEquals("welcome", "welecome");
        softAssert.assertAll();
    }
}
