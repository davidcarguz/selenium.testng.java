package core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

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

    public static MediaEntityModelProvider takeStepScreenshot(WebDriver driver,String filename,String testName) {
        File testfolder = new File("reports\\testName");
        testfolder.mkdir();
        MediaEntityModelProvider mediaModel = null;
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File srcImage = screenshot.getScreenshotAs(OutputType.FILE);
        String filepath = "reports\\"+testName+"\\"+filename+".png";
        File destFile = new File(filepath);
        try {
            FileUtils.copyFile(srcImage, destFile);
            mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(testName+"\\"+filename+".png").build();
        }catch (Exception e){
            e.printStackTrace();
        }
        return mediaModel;
    }
}
