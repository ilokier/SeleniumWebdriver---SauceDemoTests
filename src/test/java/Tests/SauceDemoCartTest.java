package Tests;

import Pages.SaucedemoLocatorsPage;
import Pages.SwagLabsLocatorsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners({CustomListener.class})

public class SauceDemoCartTest extends TestBase{
    private SaucedemoLocatorsPage saucedemoLocatorsPage;
    private SwagLabsLocatorsPage swagLabsLocatorsPage;


    @DataProvider(name = "data-provider")
    public Object [][] dataForRegistration() {
        return new Object[][] {
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}

        };
    }

    @org.testng.annotations.Test(dataProvider = "data-provider")
    public void WhenItemAddedToCartShouldBeWisibleInCart(String username, String password) {
        saucedemoLocatorsPage = PageFactory.initElements(driver, SaucedemoLocatorsPage.class);
        swagLabsLocatorsPage = PageFactory.initElements(driver, SwagLabsLocatorsPage.class);
        saucedemoLocatorsPage.fillUsername(username);
        saucedemoLocatorsPage.fillPassword(password);
        saucedemoLocatorsPage.clickLoginButton();
        swagLabsLocatorsPage.pickBackpack();
        swagLabsLocatorsPage.addBackpackToCart();
        swagLabsLocatorsPage.goToCart();

        String cartItem = swagLabsLocatorsPage.getItemText();
        Assert.assertEquals(cartItem, "Sauce Labs Backpack");
        System.out.println("item name is: " + cartItem);
    }

    @org.testng.annotations.Test (dataProvider = "data-provider")
    public void WhenItemRemovedCasrtShouldBeEmpty(String username, String password) {
        saucedemoLocatorsPage = PageFactory.initElements(driver, SaucedemoLocatorsPage.class);
        swagLabsLocatorsPage = PageFactory.initElements(driver, SwagLabsLocatorsPage.class);
        saucedemoLocatorsPage.fillUsername(username);
        saucedemoLocatorsPage.fillPassword(password);
        saucedemoLocatorsPage.clickLoginButton();
        swagLabsLocatorsPage.pickBackpack();
        swagLabsLocatorsPage.addBackpackToCart();
        swagLabsLocatorsPage.goToCart();
        swagLabsLocatorsPage.removeItemFromCart();
        Assert.assertTrue(swagLabsLocatorsPage.checkIfCartIsEmpty().isEmpty());
    }
}


