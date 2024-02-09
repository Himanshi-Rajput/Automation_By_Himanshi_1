package TestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGSoftAssertion4 extends TestNGExtentReport{

    SoftAssert softAssert1 = new SoftAssert();
    SoftAssert softAssert2 = new SoftAssert();
    SoftAssert softAssert3 = new SoftAssert();

    @Test
    void demo3() {
        test = reports.startTest("TestCase7", "Failed Testcase");
        softAssert1.assertTrue(true);
        softAssert1.assertEquals("Himanshi", "himanshi");
        softAssert1.assertEquals("Selenium", "Selenium");
        System.out.println("Method 3rd");
        softAssert1.assertAll();
    }

    @Test
    void demo2() {
        test = reports.startTest("TestCase8", "Passed Testcase");
        softAssert2.assertEquals("welcome", "welcome");
        softAssert2.assertAll();
    }

    @Test
    void demo1() {
        test = reports.startTest("TestCase9", "Failed Testcase");
        softAssert3.assertEquals("welcome", "welecome");
        softAssert3.assertAll();
    }
}
