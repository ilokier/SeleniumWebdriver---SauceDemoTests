package Pages;

import Pages.ProductDetailPages.ProductDetailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage {
    private static Logger log = LoggerFactory.getLogger("CartPage.class");

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cart_item")
    List<WebElement> cartInventoryItem;
    @FindBy(id = "shopping_cart_container")
    WebElement cartItemsCounter;


    public List<String> getItemList() {
        List<String> productNames = cartInventoryItem.stream()
                .map(product -> new ProductDetailPage(product).getItemName())
                .collect(Collectors.toList());
        return productNames;
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

}
