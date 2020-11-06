package Tests;

import Pages.SaucedemoLocatorsPage;
import Pages.SwagLabsLocatorsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class SauceDemoCartTest extends SauceDemoPositiveLoginTest {

    WebDriver driver;
    private SaucedemoLocatorsPage saucedemoLocatorsPage;
    private SwagLabsLocatorsPage swagLabsLocatorsPage;
    private WebDriverWait wait;
    private SwagLabsLocatorsPage cartItem;
    protected final static String BASE_URL = "https://www.saucedemo.com/";

    //dane do rejestracji
    @Parameterized.Parameter(0)
    public String usernameParameter;
    @Parameterized.Parameter(1)
    public String passwordParameter;

    @Parameterized.Parameters(name = "Test {index}: username: {0}, password: {1}")
    public static Collection<Object[]> dataForRegistration() {
        return Arrays.asList(new Object[][]{
                {"standard_user", "secret_sauce"},
        });
    }

    @Before
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "/home/lonia/Pulpit/szkolenia, materiały/projekty/Test/src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        saucedemoLocatorsPage = new SaucedemoLocatorsPage(driver);
        swagLabsLocatorsPage = new SwagLabsLocatorsPage(driver);
        saucedemoLocatorsPage.logIn(usernameParameter, passwordParameter);

    }

    @Test
    public void WhenItemAddedToCartShouldBeWisibleInCart() {
        swagLabsLocatorsPage.pickBackpack();
        swagLabsLocatorsPage.addBackpackToCart();
        swagLabsLocatorsPage.goToCart();

        String cartItem = swagLabsLocatorsPage.getItemText();
        Assertions.assertEquals(cartItem, "Sauce Labs Backpack");
        System.out.println("item name is: " + cartItem);
        swagLabsLocatorsPage.removeItemFromCart();
        String cartItems = swagLabsLocatorsPage.getCartItems();
        System.out.println(cartItems);
        Assertions.assertNotEquals(cartItems, "Sauce Labs Backpack");
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }
}


