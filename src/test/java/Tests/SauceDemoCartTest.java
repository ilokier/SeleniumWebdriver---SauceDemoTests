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

public class SauceDemoCartTest extends TestBase{
    private SaucedemoLocatorsPage saucedemoLocatorsPage;
    private SwagLabsLocatorsPage swagLabsLocatorsPage;



    //login data
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


    @Test
    public void WhenItemAddedToCartShouldBeWisibleInCart() {
        saucedemoLocatorsPage = PageFactory.initElements(driver, SaucedemoLocatorsPage.class);
        swagLabsLocatorsPage = PageFactory.initElements(driver, SwagLabsLocatorsPage.class);
        saucedemoLocatorsPage.fillUsername(usernameParameter);
        saucedemoLocatorsPage.fillPassword(passwordParameter);
        saucedemoLocatorsPage.clickLoginButton();
        swagLabsLocatorsPage.pickBackpack();
        swagLabsLocatorsPage.addBackpackToCart();
        swagLabsLocatorsPage.goToCart();

        String cartItem = swagLabsLocatorsPage.getItemText();
        Assertions.assertEquals(cartItem, "Sauce Labs Backpack");
        System.out.println("item name is: " + cartItem);

    }

    @Test
    public void WhenItemRemovedCasrtShouldBeEmpty() {
        saucedemoLocatorsPage = PageFactory.initElements(driver, SaucedemoLocatorsPage.class);
        swagLabsLocatorsPage = PageFactory.initElements(driver, SwagLabsLocatorsPage.class);
        saucedemoLocatorsPage.fillUsername(usernameParameter);
        saucedemoLocatorsPage.fillPassword(passwordParameter);
        saucedemoLocatorsPage.clickLoginButton();
        swagLabsLocatorsPage.pickBackpack();
        swagLabsLocatorsPage.addBackpackToCart();
        swagLabsLocatorsPage.goToCart();
        swagLabsLocatorsPage.removeItemFromCart();
        Assertions.assertTrue(swagLabsLocatorsPage.checkIfCartIsEmpty().isEmpty());
    }



}


