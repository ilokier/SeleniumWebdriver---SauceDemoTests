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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class SauceDemoPositiveLoginTest {
    WebDriver driver;
    private SaucedemoLocatorsPage saucedemoLocatorsPage;
    private WebDriverWait wait;
    protected final static String BASE_URL = "https://www.saucedemo.com/";

    //dane do rejestracji
    @Parameterized.Parameter(0)
    public String usernameParameter;
    @Parameterized.Parameter(1)
    public String passwordParameter;


    @Parameters(name = "Test {index}: username: {0}, password: {1}")
    public static Collection<Object[]> dataForRegistration() {
        return Arrays.asList(new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
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
    public void WhenAccurateDataPutedShouldLoggin() {
        saucedemoLocatorsPage = new SaucedemoLocatorsPage(driver);
        saucedemoLocatorsPage.logIn(usernameParameter, passwordParameter);

        Assertions.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }


}