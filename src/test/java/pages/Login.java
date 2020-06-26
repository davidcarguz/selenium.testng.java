package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login {

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
        }catch(Exception e){
            final String ERROR_MESSAGE = "there was a problem clicking login button";
            throw new Error(ERROR_MESSAGE,e);
        }
        return this;
    }

    public void checkWrongCredentialsMessage(){
        try{
            Assert.assertTrue(lbl_WrongCredentials.isDisplayed());
        }catch(Exception|AssertionError e){
            final String ERROR_MESSAGE = "Login with wrong credentials is not working";
            throw new Error(ERROR_MESSAGE,e);
        }
    }

}
