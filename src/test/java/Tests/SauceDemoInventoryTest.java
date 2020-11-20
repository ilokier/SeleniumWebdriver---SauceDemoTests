package Tests;

import Pages.SaucedemoLocatorsPage;
import Pages.SwagLabsLocatorsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({CustomListener.class})

public class SauceDemoInventoryTest extends TestBase {
    SaucedemoLocatorsPage saucedemoLocatorsPage;
    SwagLabsLocatorsPage swagLabsLocatorsPage;

    @DataProvider(name = "data-provider")
    public Object[][] dataForRegistration() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}

        };
    }

    @BeforeMethod
    void beforeMetod() {
        saucedemoLocatorsPage = PageFactory.initElements(driver, SaucedemoLocatorsPage.class);
        swagLabsLocatorsPage = PageFactory.initElements(driver, SwagLabsLocatorsPage.class);
    }

    @Test(dataProvider = "data-provider")
    public void WhenUserIsLoggedInItemsShouldBeVisible(String username, String password) {
        saucedemoLocatorsPage.logIn(username, password);
        Assert.assertEquals(swagLabsLocatorsPage.imageValue(), "https://www.saucedemo.com/img/sauce-backpack-1200x1500.jpg");

    }
}
