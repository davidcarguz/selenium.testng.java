package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import step_definitions.Hooks;

public class Login extends Hooks {

    WebDriver driver;

    @FindBy(how = How.ID, using = "txtUsername")
    private WebElement edt_Username;
    @FindBy(how = How.ID, using = "txtPassword")
    private WebElement edt_Password;
    @FindBy(how = How.ID, using = "btnLogin")
    private WebElement btn_Login;
    @FindBy(how = How.ID, using = "spanMessage")
    private WebElement lbl_WrongCredentials;

    public Login(WebDriver driver) {
        this.driver =driver;
        PageFactory.initElements(this.driver,this);
    }

    /**
     * Fills the username field.
     * @param username to log in to the app.
     * @return {@link Login}
     */
    public Login enterUsername(String username){
        try {
            edt_Username.clear();
            edt_Username.sendKeys(username);
            test.info("fill username field with username: "+username,takeStepScreenshot(driver,"insert_username",testName));
        }catch(Exception e){
            final String ERROR_MESSAGE = "there was a problem filling username";
            throw new Error(ERROR_MESSAGE,e);
        }
        return this;
    }

    /**
     * Fills the password field.
     * @param password to log in along with an specific user.
     * @return {@link Login}
     */
    public Login enterPassword(String password){
        try {
            edt_Password.clear();
            edt_Password.sendKeys(password);
            test.info("fill password field with password: "+password,takeStepScreenshot(driver,"insert_password",testName));
        }catch(Exception e){
            final String ERROR_MESSAGE = "there was a problem filling password";
            throw new Error(ERROR_MESSAGE,e);
        }
        return this;
    }

    /**
     * Clicks on log in button.
     * @return {@link Login}
     */
    public Login clickLoginButton(){
        try {
            btn_Login.click();
            test.info("click on login button,",takeStepScreenshot(driver,"click_on_button",testName));
        }catch(Exception e){
            final String ERROR_MESSAGE = "there was a problem clicking login button";
            throw new Error(ERROR_MESSAGE,e);
        }
        return this;
    }

    public void checkWrongCredentialsMessage(){
        try{
            Assert.assertTrue(lbl_WrongCredentials.isDisplayed());
            test.pass("login validation succesful.",takeStepScreenshot(driver,"wrong_credentials_sucessful",testName));
        }catch(Exception|AssertionError e){
            final String ERROR_MESSAGE = "Login with wrong credentials is not working";
            test.fail("There was a problem with the login validation.");
            throw new Error(ERROR_MESSAGE,e);
        }
    }

}
