package Tests;

import Pages.SauceDemoCartPage;
import Pages.SaucedemoLocatorsPage;
import Pages.SwagLabsLocatorsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

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

    @org.testng.annotations.Test(dataProvider = "data-provider")
    public void WhenItemAddedToCartShouldBeWisibleInCart(String username, String password) {
        saucedemoLocatorsPage = PageFactory.initElements(driver, SaucedemoLocatorsPage.class);
        swagLabsLocatorsPage = PageFactory.initElements(driver, SwagLabsLocatorsPage.class);
        sauceDemoCartPage = PageFactory.initElements(driver, SauceDemoCartPage.class);
        saucedemoLocatorsPage.fillUsername(username);
        saucedemoLocatorsPage.fillPassword(password);
        saucedemoLocatorsPage.clickLoginButton();
        swagLabsLocatorsPage.pickBackpack();
        swagLabsLocatorsPage.addBackpackToCart();
        swagLabsLocatorsPage.goToCart();

        String cartItem = sauceDemoCartPage.getItemText();
        Assert.assertEquals(cartItem, "Sauce Labs Backpack");
        System.out.println("item name is: " + cartItem);
    }

    @org.testng.annotations.Test(dataProvider = "data-provider")
    public void WhenItemRemovedCasrtShouldBeEmpty(String username, String password) {
        saucedemoLocatorsPage = PageFactory.initElements(driver, SaucedemoLocatorsPage.class);
        swagLabsLocatorsPage = PageFactory.initElements(driver, SwagLabsLocatorsPage.class);
        sauceDemoCartPage = PageFactory.initElements(driver, SauceDemoCartPage.class);
        saucedemoLocatorsPage.fillUsername(username);
        saucedemoLocatorsPage.fillPassword(password);
        saucedemoLocatorsPage.clickLoginButton();
        swagLabsLocatorsPage.pickBackpack();
        swagLabsLocatorsPage.addBackpackToCart();
        swagLabsLocatorsPage.goToCart();
        sauceDemoCartPage.removeItemFromCart();
        Assert.assertTrue(sauceDemoCartPage.checkIfCartIsEmpty().isEmpty());
    }
}


