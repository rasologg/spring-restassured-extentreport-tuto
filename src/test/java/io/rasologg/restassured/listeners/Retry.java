package io.rasologg.restassured.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int count = 0;
    private static int maxTry = 1;
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()){
            if(count < maxTry){
                count++;
                iTestResult.setStatus(iTestResult.FAILURE);
                extendReportsFailOperations(ITestResult.SUCCESS);
                return true;
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }

    public void extendReportsFailOperations(int iTestResult){
    }
}

