package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Home {

    WebDriver driver;

    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement lbl_Dashboard;

    public Home(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /**
     * Checks if the Dashboard element is displayed.
     */
    public void checkDashboardIsPresent(){
        try {
            Assert.assertTrue(lbl_Dashboard.isDisplayed());
        }catch(Exception e){
            final String ERROR_MESSAGE = "there was an error finding dashboard label";
            throw new Error(ERROR_MESSAGE,e);
        }
    }
}
