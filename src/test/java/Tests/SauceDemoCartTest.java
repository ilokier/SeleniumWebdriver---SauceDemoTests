package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({CustomListener.class})

public class SauceDemoCartTest extends TestBase {
    //    private SwagLabsLocatorsPage swagLabsLocatorsPage;

    @DataProvider(name = "data-provider")
    public Object[][] dataForRegistration() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
        };
    }

    @Test(dataProvider = "data-provider")
    public void WhenItemAddedToCartShouldBeWisibleInCart(String username, String password) {
        swagLabsLocatorsPage = saucedemoLocatorsPage.logIn(username, password);
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


