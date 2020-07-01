package step_definitions;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.Home;
import pages.Login;

public class LoginSteps extends Hooks{

    @Test(groups = {"all"})
    @Parameters({"username","password"})
    public void successfulLogin(String username, String password){
        Login login = new Login(getDriver());
        Home home = new Home(getDriver());
        login.enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();
        home.checkDashboardIsPresent();
    }

    @Test(groups = {"wrong_credentials","all"}, dataProvider = "login_credentials", dataProviderClass = core.DataProviderStack.class)
    public void wrongCredentialsLogin(String username, String password){
        Login login = new Login(getDriver());
        login.enterUsername(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkWrongCredentialsMessage();
    }

    @Test(groups = {"wrong_credentials","all"})
    public void loginWithNoCredentials(){
        Login login = new Login(getDriver());
        login.enterUsername("")
                .enterPassword("")
                .clickLoginButton()
                .checkWrongCredentialsMessage();
    }

}
