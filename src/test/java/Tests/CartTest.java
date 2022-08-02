package Tests;

import Tests.Helpers.CustomListener;
import Tests.Steps.AddToCartStep;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Listeners({CustomListener.class})

public class CartTest extends TestBase {

    @Test
    public void WhenItemAddedToCartShouldBeVisibleInCart() {
        productsPage = positiveLoginStep.logStandarUser();
        cartPage = new AddToCartStep(driver).addItemToCart();
        cartPage.removeItemFromCart();
        assertThat(cartPage.checkNumberOfProductsInCart(), equalTo(0));
    }
}


