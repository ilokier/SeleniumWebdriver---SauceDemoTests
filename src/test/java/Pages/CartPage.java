package Pages;

import Models.ItemModel;
import Pages.ProductDetailPages.ProductDetailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage {

    @FindBy(css = ".cart_item")
    private List<WebElement> cartInventoryItem;
    @FindBy(css = "#checkout")
    private WebElement checkoutButton;

    private static Logger log = LoggerFactory.getLogger("CartPage.class");

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<ItemModel> getItemList() {
        List<ItemModel> products = cartInventoryItem.stream()
                .map(product -> new ItemModel(new ProductDetailPage(product).getItemName(), new ProductDetailPage(product).getItemPrice()))
                .collect(Collectors.toList());
        log.info("Cart item list: " + products);
        return products;
    }


    public CartPage removeItemFromCart() {
        new ProductDetailPage(cartInventoryItem.get(0)).getRemoveButton().click();
        return this;
    }

    public int checkNumberOfProductsInCart() {
        int numberOfProducts = cartInventoryItem.size();
        log.info("Number of products in cart: " + numberOfProducts);
        return numberOfProducts;
    }

    public CartPage checkout() {
        clickOnElement(checkoutButton);
        return this;
    }

}
