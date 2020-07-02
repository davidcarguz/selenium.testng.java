package core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportManager {

    public static ExtentReports report;
    public static ExtentTest test;

    public void setupReport(){
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("reports/report-html.html");
        report = new ExtentReports();
        report.attachReporter(htmlReporter);
    }

    public void setupTest(String testName){
        test = report.createTest(testName);
    }
}
