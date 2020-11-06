package Tests;

import Pages.SaucedemoLocatorsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class SauceDemoNegativeLoginTest {
    private WebDriver driver;
    String error;
    private SaucedemoLocatorsPage saucedemoLocatorsPage;
    protected final static String BASE_URL = "https://www.saucedemo.com/";

    //dane do rejestracji
    @Parameterized.Parameter(0)
    public String usernameParameter;
    @Parameterized.Parameter(1)
    public String passwordParameter;

    @Parameters(name = "Test {index}:, username: {0}, password: {1}")
    public static Collection<Object[]> dataForNegaitveRegistration() {
        return Arrays.asList(new Object[][]{
                {"incorrect_login", "secret_sauce"},
                {"locked_out_user", "incerrect_password"},git
                {"incorrect_login", "incerrect_password"}
        });
    }

    @Before
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "/home/lonia/Pulpit/szkolenia, materiały/projekty/Test/src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
        driver.get(BASE_URL);

    }

    @Test
    public void GivenIncorrectLoginDataUserShouldNotBeenLogged() {
        saucedemoLocatorsPage = new SaucedemoLocatorsPage(driver);
        saucedemoLocatorsPage.logIn(usernameParameter, passwordParameter);

        Assertions.assertTrue(saucedemoLocatorsPage.getErrorMessage(error).contains("Username and password do not match any user in this service"));
        System.out.println("error message: " + error);
    }

    @After
    public void Quit() {
        driver.quit();
    }

}
