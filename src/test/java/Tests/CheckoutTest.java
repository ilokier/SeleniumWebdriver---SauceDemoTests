package Tests;

import Pages.CheckoutPage;
import Pages.UserFaktory;
import Tests.Steps.AddToCartStep;
import org.testng.annotations.Test;

public class CheckoutTest extends TestBase {

    @Test
    public void ItemShouldBeSameInCheckout() {
        productsPage = positiveLoginStep.logStandarUser();
        cartPage = new AddToCartStep(driver)
                .addItemsToCart()
                .checkout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillUserData(new UserFaktory(driver).getRandomUser());
    }
}
