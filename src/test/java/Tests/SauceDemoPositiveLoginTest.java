package Tests;

import Pages.SaucedemoLocatorsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceDemoPositiveLoginTest extends TestBase{
    SaucedemoLocatorsPage saucedemoLocatorsPage;

    @DataProvider(name = "data-provider")
    public Object [][] dataForRegistration() {
        return new Object[][] {
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}
        };
    }

    @Test(dataProvider = "data-provider")
    public void WhenAccurateDataPutShouldLogin (String username, String password) {
        saucedemoLocatorsPage = PageFactory.initElements(driver, SaucedemoLocatorsPage.class);
        saucedemoLocatorsPage.fillUsername(username);
        saucedemoLocatorsPage.fillPassword(password);
        saucedemoLocatorsPage.clickLoginButton();
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

}