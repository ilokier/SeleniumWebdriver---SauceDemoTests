package Tests.Steps;

import Models.ItemModel;
import Pages.CartPage;
import Pages.ProductsPage;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.List;

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
        return new CartPage(driver);
    }

    public CartPage addItemsToCart() {
        productsPage = new ProductsPage(driver);
        itemList = productsPage.addRandomListOfItemsToCart(5);
        cartPage = productsPage.goToCart();
        Matchers.containsInAnyOrder(cartPage.getItemList(), itemList);
        return new CartPage(driver);
    }
}
