package io.rasologg.restassured.listeners;

import com.aventstack.extentreports.Status;
import io.rasologg.restassured.extentreports.ExtentManager;
import io.rasologg.restassured.extentreports.ExtentTestManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public static String getTestMethodName(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public void onTestStart(ITestResult result) {
        System.out.println("I am in onTestStart method "+ getTestMethodName(result)+ "start");
        ExtentTestManager.startTest(result.getMethod().getMethodName(),"");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("I am in onTestSuccess method " + getTestMethodName(result)+ " succeed");
        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("I am in onTestFailure method " + getTestMethodName(result)+ "failed");
        ExtentTestManager.getTest().log(Status.FAIL, "Test failed");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("I am in onTestSkipped method " + getTestMethodName(result)+ " skipped");
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test failed but it is in defined success ratio "+ getTestMethodName(result));
    }

    public void onTestFailedWithTimeout(ITestResult result) {

    }

    public void onFinish(ITestContext context) {
        System.out.println("I am in onFinish method " + context.getName());
        ExtentManager.getReporter().flush();
    }

    public void onStart(ITestContext iTestContext){
        System.out.println("I am in onStart method "+ iTestContext.getName());
    }
}

