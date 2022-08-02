package Tests;

import Tests.Data.LoginData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static java.lang.System.getProperty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Listeners({CustomListener.class})

public class NegativeLoginTest extends TestBase {


    @AfterMethod
    public void refresh() {
        driver.navigate().refresh();
    }

    @Test(dataProvider = "badCredentials", dataProviderClass = LoginData.class)
    public void GivenIncorrectLoginDataShouldShowErrorMessage(String username, String password) {
        loginPage
                .logIn(username, password);
        assertThat(loginPage.getErrorMessage(), is(getProperty("bad_credentials_message")));

    }
}

