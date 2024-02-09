package TestCases;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class TestNGTC1Listeners extends TestListenerAdapter
{
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        super.onTestSuccess(iTestResult);
        System.out.println("Test is passed");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        super.onStart(iTestContext);
        System.out.println("Test Started");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        super.onTestFailure(iTestResult);
        System.out.println("Testcase is failed");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        super.onTestFailedButWithinSuccessPercentage(iTestResult);
        System.out.println("Test Case is failed with low percentage.");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        super.onTestSkipped(iTestResult);
        System.out.println("Test is skipped");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        super.onFinish(iTestContext);
        System.out.println("Test is finished.");
    }
}
