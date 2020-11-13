package Tests;

import Pages.SaucedemoLocatorsPage;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class SauceDemoNegativeLoginTest extends TestBase{
    private SaucedemoLocatorsPage saucedemoLocatorsPage;


    //login data
    @Parameterized.Parameter(0)
    public String usernameParameter;
    @Parameterized.Parameter(1)
    public String passwordParameter;

    @Parameters(name = "Test {index}:, username: {0}, password: {1}")
    public static Collection<Object[]> dataForNegaitveRegistration() {
        return Arrays.asList(new Object[][]{
                {"standard_user", "invalid_password"},
                {"invalid_user", "secret_sauce"},
                {"invalid_user", "invalid_password"}
        });
    }

    @Test
    public void GivenIncorrectLoginDataUserShouldNotBeenLogged() {
        saucedemoLocatorsPage = PageFactory.initElements(driver, SaucedemoLocatorsPage.class);
        saucedemoLocatorsPage.fillUsername(usernameParameter);
        saucedemoLocatorsPage.fillPassword(passwordParameter);
        saucedemoLocatorsPage.clickLoginButton();

        Assertions.assertTrue(saucedemoLocatorsPage.getErrorMessage().contains("Username and password do not match any user in this service"));
    }
}

