package io.rasologg.restassured.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(){
        String workingDir = System.getProperty("user.dir");
        ExtentSparkReporter  htmlReporter = new ExtentSparkReporter(workingDir+"\\ExtentReports\\ExtentReportResults.html");
        if(extent == null){
            extent = new ExtentReports();
        }
        htmlReporter.config().setDocumentTitle("RestAssured Tests"); // Tittle of Report
        htmlReporter.config().setReportName("Extent Report V4"); // Name of the report
        htmlReporter.config().setTheme(Theme.DARK);//Default Theme of Report

        // General information releated to application
        extent.setSystemInfo("Application Name", "RestAssured Tests");
        extent.setSystemInfo("User Name", "rasologg");
        extent.setSystemInfo("Envirnoment", "CI");
        extent.attachReporter(htmlReporter);
        return extent;
    }
}
