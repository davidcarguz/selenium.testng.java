package core;

import org.testng.annotations.DataProvider;

public class DataProviderStack {

    @DataProvider(name = "login_credentials")
    public Object[][] getCredentials(){
        return new Object[][] {
                {"Admin","Admin"},
        };
    }
}
