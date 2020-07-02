package step_definitions;

import core.ReportManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Hooks extends ReportManager {

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void suiteSetup(){
        setupReport();
    }

    @BeforeMethod(alwaysRun = true)
    public void setupTest(ITestResult method) {
        setupTest(method.getMethod().getMethodName());
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        test.info("Open Browser in HomePage",takeStepScreenshot(driver,"navigate_to_page"));
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
