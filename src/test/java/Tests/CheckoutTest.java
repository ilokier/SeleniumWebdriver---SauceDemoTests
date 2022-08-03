package Tests;

import Models.ItemModel;
import Tests.Helpers.UserFactory;
import Tests.Steps.AddToCartStep;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.System.getProperty;

public class CheckoutTest extends TestBase {

    @Test
    public void ItemShouldBeSameInCheckout() {
        productsPage = positiveLoginStep.logStandardUser();
        cartPage = new AddToCartStep(driver)
                .addItemsToCart();
        List<ItemModel> cartItemList = cartPage.getItemList();
        cartPage.checkout();
        checkoutPage.fillUserData(new UserFactory(driver).getRandomUser());

        softAssert.assertEquals(checkoutPage.getCheckoutProductList(), cartItemList);
        softAssert.assertEquals(checkoutPage.getHeaderTitle(), getProperty("checkoutHeaderTitle"));
        softAssert.assertEquals(checkoutPage.finishOrder(), getProperty("thanksMessage"));
        softAssert.assertEquals(checkoutPage.getHeaderTitle(), getProperty("finishHeaderTitle"));
        softAssert.assertAll();
    }
}
