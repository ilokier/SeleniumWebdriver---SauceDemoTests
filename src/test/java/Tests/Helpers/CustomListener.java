package Tests.Helpers;

import Tests.TestBase;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends TestBase implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("!!!!!!!!!!!!!!!!!!!Im starting test: " + iTestResult.getName() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("!!!!!!!!!!!!!!!!!!!Test: " + "\"" + iTestResult.getName() + "\"" + " passed!!!!!!!!!!!!!!!!!!!!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("!!!!!!!!!!!!!!!!!!!Test failed: " + result.getName() + "!!!!!!!!!!!!!!!!!!!");
        capture(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("!!!!!!!!!!!!!!!!!!!Test skipped: " + result.getName() + "!!!!!!!!!!!!!!!!!!!");
        capture(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }
}