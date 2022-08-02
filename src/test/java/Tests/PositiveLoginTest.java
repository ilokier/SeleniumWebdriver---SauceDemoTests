package Tests;

import Tests.Data.LoginData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static java.lang.System.getProperty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Listeners({CustomListener.class})

public class PositiveLoginTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger("SauceDemoInventoryTest.class");


    @Test(dataProvider = "goodCredentials", dataProviderClass = LoginData.class)
    public void WhenUserIsLoggedInHeaderShouldDisplayProperTitle(String username) {
        productsPage = loginPage.logIn(username, getProperty("password"));
        String title = (productsPage.getHeaderTitle());
        productsPage.logOut();
        assertThat(title, is(getProperty("headerTitle")));
    }
}
