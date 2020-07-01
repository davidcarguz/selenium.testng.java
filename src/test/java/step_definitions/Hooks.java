package step_definitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Hooks {

    private WebDriver driver;
    public static ExtentReports report;
    public static ExtentTest test;

    @BeforeClass(alwaysRun = true)
    public void suiteSetup(){
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("reports/report-html.html");
        report = new ExtentReports();
        report.attachReporter(htmlReporter);
    }

    @BeforeMethod(alwaysRun = true)
    public void setupTest(ITestResult method) {
        System.out.println("Nombre caso: "+method.getMethod().getMethodName());
        test = report.createTest(method.getMethod().getMethodName());
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        test.info("Open Browser in HomePage");
    }

    @AfterMethod(alwaysRun = true)
    public void finishTest(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            test.fail("there was a problem with the test case.");
        }
        driver.quit();
    }

    @AfterClass(alwaysRun = true)
    public void finishReport(){
        report.flush();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
