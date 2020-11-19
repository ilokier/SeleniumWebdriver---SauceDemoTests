package Tests;

import Pages.SaucedemoLocatorsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners({CustomListener.class})

public class SauceDemoNegativeLoginTest extends TestBase{
    private SaucedemoLocatorsPage saucedemoLocatorsPage;

    @DataProvider(name = "data-provider")
    public Object [][] dataForRegistration() {
        return new Object[][] {
                {"standard_user", "incorrect_password"},
                {"invalid_user", "secret_sauce"},
                {"invalid_user", "invalid_password"}
        };
    }

    @org.testng.annotations.Test(dataProvider = "data-provider")
    public void GivenIncorrectLoginDataUserShouldNotBeenLogedIn(String username, String password) {
        saucedemoLocatorsPage = PageFactory.initElements(driver, SaucedemoLocatorsPage.class);
        saucedemoLocatorsPage.fillUsername(username);
        saucedemoLocatorsPage.fillPassword(password);
        saucedemoLocatorsPage.clickLoginButton();

        Assert.assertTrue(saucedemoLocatorsPage.getErrorMessage().contains("Username and password do not match any user in this service"));
    }
}

