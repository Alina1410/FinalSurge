package tests.base;

import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        log.info(">>>>>>>>>>>>>>>>>>>TEST START: " + result.getName() + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test success: %s " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("Test failure: %s " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("Test skipped: %s " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.info("Test Failed But Within Success Percentage: %s" + result.getName());
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {


    }
}
