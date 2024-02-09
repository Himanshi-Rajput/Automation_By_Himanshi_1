package TestCases;
import org.testng.annotations.*;

public class TestNGExample
{

        @BeforeSuite
        public void beforeSuite() {
            System.out.println("Before Suite");
        }

        @AfterSuite
        public void afterSuite() {
            System.out.println("After Suite");
        }

        @BeforeTest
        public void beforeTest() {
            System.out.println("Before Test");
        }

        @AfterTest
        public void afterTest() {
            System.out.println("After Test");
        }

        @BeforeClass
        public void beforeClass() {
            System.out.println("Before Class");
        }

        @AfterClass
        public void afterClass() {
            System.out.println("After Class");
        }

        @BeforeGroups("group1")
        public void beforeGroup1() {
            System.out.println("Before Group 1");
        }

        @AfterGroups("group1")
        public void afterGroup1() {
            System.out.println("After Group 1");
        }

        @BeforeMethod
        public void beforeMethod() {
            System.out.println("Before Method");
        }

        @AfterMethod
        public void afterMethod() {
            System.out.println("After Method");
        }

        @Test(groups = "group1")
        public void testMethod1() {
            System.out.println("Test Method 1");
        }

        @Test(groups = "group2")
        public void testMethod2() {
            System.out.println("Test Method 2");
        }
}


