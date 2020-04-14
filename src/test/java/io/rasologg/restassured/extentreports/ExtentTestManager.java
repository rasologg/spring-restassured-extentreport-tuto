package io.rasologg.restassured.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
    static Map extentTestMap = new HashMap();
    static ExtentReports extent = ExtentManager.getReporter();


    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get(Thread.currentThread().getId());
    }
    /*
        public static synchronized void endTest() {
            extent.endTest((ExtentTest) extentTestMap.get(Thread.currentThread().getId()));
        }
    */
    public static synchronized ExtentTest startTest(String testName, String s) {
        ExtentTest test = extent.createTest(testName, s);
        extentTestMap.put(Thread.currentThread().getId(), test);
        return test;
    }
}
