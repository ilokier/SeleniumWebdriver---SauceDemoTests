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

    @DataProvider(name = "data-provider2")
    public Object[][] dataForRegistration() {
        return new Object[][]{
                {getProperty("standard_username"), getProperty("password")},
                {getProperty("problem_username"), getProperty("password")},
                {getProperty("performance_username"), getProperty("password")}

        };

    }

    @Test(dataProvider = "data-provider2")
    public void WhenUserIsLoggedInItemsShouldBeVisible(String username, String password) {
        swagLabsLocatorsPage = saucedemoLocatorsPage.logIn(username, password);
        String title = (swagLabsLocatorsPage.getHeaderTitle());
        swagLabsLocatorsPage.logOut();
        assertThat(title, is(getProperty("headerTitle")));
    }
}
