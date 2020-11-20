package Tests;

import Pages.SauceDemoCartPage;
import Pages.SaucedemoLocatorsPage;
import Pages.SwagLabsLocatorsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({CustomListener.class})

public class SauceDemoCartTest extends TestBase {
    private SaucedemoLocatorsPage saucedemoLocatorsPage;
    private SwagLabsLocatorsPage swagLabsLocatorsPage;
    private SauceDemoCartPage sauceDemoCartPage;

    @DataProvider(name = "data-provider")
    public Object[][] dataForRegistration() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
        };
    }

    @BeforeMethod
    void beforeMethod() {
        saucedemoLocatorsPage = PageFactory.initElements(driver, SaucedemoLocatorsPage.class);
        swagLabsLocatorsPage = PageFactory.initElements(driver, SwagLabsLocatorsPage.class);
        sauceDemoCartPage = PageFactory.initElements(driver, SauceDemoCartPage.class);

    }

    @Test (dataProvider = "data-provider")
    public void WhenItemAddedToCartShouldBeWisibleInCart(String username, String password) {
        saucedemoLocatorsPage.logIn(username, password);
        swagLabsLocatorsPage.pickBackpack().addBackpackToCart().goToCart();

        String cartItem = sauceDemoCartPage.getItemText();
        Assert.assertEquals(cartItem, "Sauce Labs Backpack");
        System.out.println("item name is: " + cartItem);
    }

    @Test(dataProvider = "data-provider")
    public void WhenItemRemovedCasrtShouldBeEmpty(String username, String password) {
        saucedemoLocatorsPage.logIn(username, password);
        swagLabsLocatorsPage.pickBackpack().addBackpackToCart().goToCart();
        sauceDemoCartPage.removeItemFromCart();
        Assert.assertTrue(sauceDemoCartPage.checkIfCartIsEmpty().isEmpty());
    }
}


