package Tests;

import Pages.SaucedemoLocatorsPage;
import Pages.SwagLabsLocatorsPage;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class SauceDemoPositiveLoginTest extends TestBase{
    SaucedemoLocatorsPage saucedemoLocatorsPage;
    SwagLabsLocatorsPage swagLabsLocatorsPage;

    //login data
    @Parameterized.Parameter(0)
    public String usernameParameter;
    @Parameterized.Parameter(1)
    public String passwordParameter;


    @Parameterized.Parameters(name = "Test {index}: username: {0}, password: {1}")
    public static Collection<Object[]> dataForRegistration() {
        return Arrays.asList(new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
        });
    }

    @Test
    public void WhenAccurateDataPutedShouldLoggin () {
        saucedemoLocatorsPage = PageFactory.initElements(driver, SaucedemoLocatorsPage.class);
        saucedemoLocatorsPage.fillUsername(usernameParameter);
        saucedemoLocatorsPage.fillPassword(passwordParameter);
        saucedemoLocatorsPage.clickLoginButton();
        Assertions.assertEquals(driver.getTitle(), "Swag Labs");
    }
    @Test
    public void WhenUserIsLoggedInItemsShouldBeVisible(){
        saucedemoLocatorsPage = PageFactory.initElements(driver, SaucedemoLocatorsPage.class);
        swagLabsLocatorsPage = PageFactory.initElements(driver, SwagLabsLocatorsPage.class);
        saucedemoLocatorsPage.fillUsername(usernameParameter);
        saucedemoLocatorsPage.fillPassword(passwordParameter);
        saucedemoLocatorsPage.clickLoginButton();
        Assertions.assertTrue(swagLabsLocatorsPage.isItemImageVisible());
    }

}