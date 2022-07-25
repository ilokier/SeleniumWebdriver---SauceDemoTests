package Tests.Steps;

import Pages.CartPage;
import Pages.ProductsPage;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

public class AddToCartStep extends ProductsPage {
    private CartPage cartPage;
    private ProductsPage productsPage;

    public AddToCartStep(WebDriver driver) {
        super(driver);
    }

    public CartPage addItemToCart() {
        productsPage = new ProductsPage(driver);
        String productName = productsPage.addRandomItemToCart();
        cartPage = productsPage.goToCart();
        Matchers.containsInAnyOrder(cartPage.getItemList(), productName);
        return new CartPage(driver);
    }
}
