package Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static java.lang.System.getProperty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Listeners({CustomListener.class})

public class NegativeLoginTest extends TestBase {
    @DataProvider(name = "data-provider")
    public Object[][] dataForRegistration() {
        return new Object[][]{
                {getProperty("standard_username"), getProperty("incorrect_password")},
                {getProperty("incorrect_username"), getProperty("password")},
                {getProperty("incorrect_username"), getProperty("incorrect_password")}
        };
    }

    @AfterMethod
    public void refresh() {
        driver.navigate().refresh();
    }

    @Test(dataProvider = "data-provider")
    public void GivenIncorrectLoginDataShouldShowErrorMessage(String username, String password) {
        loginPage
                .logIn(username, password);
        assertThat(loginPage.getErrorMessage(), is(getProperty("bad_credentials_message")));

    }
}

