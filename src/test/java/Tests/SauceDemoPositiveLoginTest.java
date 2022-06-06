package Tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static java.lang.System.getProperty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Listeners({CustomListener.class})

public class SauceDemoPositiveLoginTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger("SauceDemoInventoryTest.class");

    @DataProvider(name = "data-provider")
    public Object[][] dataForRegistration() {
        return new Object[][]{
                {getProperty("standard_username")},
                {getProperty("problem_username")},
                {getProperty("performance_username")}

        };

    }

    @Test(dataProvider = "data-provider")
    public void WhenUserIsLoggedInHeaderShouldDisplayProperTitle(String username) {
        swagLabsLocatorsPage = saucedemoLocatorsPage.logIn(username, getProperty("password"));
        String title = (swagLabsLocatorsPage.getHeaderTitle());
        swagLabsLocatorsPage.logOut();
        assertThat(title, is(getProperty("headerTitle")));
    }
}
