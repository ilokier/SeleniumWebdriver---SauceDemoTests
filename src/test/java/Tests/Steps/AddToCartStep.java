package Tests.Steps;

import Models.ItemModel;
import Pages.CartPage;
import Pages.ProductsPage;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static java.lang.System.getProperty;
import static org.testng.Assert.assertEquals;

public class AddToCartStep extends ProductsPage {
    private CartPage cartPage;
    private ProductsPage productsPage;
    private ItemModel item;
    private List<ItemModel> itemList;

    public AddToCartStep(WebDriver driver) {
        super(driver);
    }

    public CartPage addItemToCart() {
        productsPage = new ProductsPage(driver);
        item = productsPage.addRandomItemToCart();
        cartPage = productsPage.goToCart();

        Matchers.containsInAnyOrder(cartPage.getItemList(), item);
        assertEquals(cartPage.getHeaderTitle(), getProperty("cartPageHeaderTitle"));
        return new CartPage(driver);
    }

    public CartPage addItemsToCart() {
        productsPage = new ProductsPage(driver);
        itemList = productsPage.addRandomListOfItemsToCart(5);
        cartPage = productsPage.goToCart();

        assertEquals(cartPage.getItemList(), itemList);
        assertEquals(cartPage.getHeaderTitle(), getProperty("cartPageHeaderTitle"));
        return new CartPage(driver);
    }
}
