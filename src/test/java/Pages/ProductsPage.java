package Pages;

import Models.ItemModel;
import Pages.ProductDetailPages.ProductDetailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(css = ".inventory_item")
    private List<WebElement> productList;
    @FindBy(css = "#shopping_cart_container")
    private WebElement cart;
    @FindBy(xpath = "//a[@id='item_4_img_link']/img")
    private WebElement itemImage;
    @FindBy(css = "#react-burger-menu-btn")
    private WebElement burgerMenu;
    @FindBy(css = "#logout_sidebar_link")
    private WebElement logOut;

    private static Logger log = LoggerFactory.getLogger("ProductsPage.class");
    private List<ItemModel> items;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ItemModel addRandomItemToCart() {
        ProductDetailPage randomProduct = selectRandomItem();
        log.info("Random product is: " + randomProduct.getItemName());
        addToCart(randomProduct);
        return new ItemModel(randomProduct.getItemName(), randomProduct.getItemPrice());
    }

    public List<ItemModel> addRandomListOfItemsToCart(int numOfItems) {
        items = new ArrayList<>();
        List<String> products = new ArrayList<>();
        for (int i = 0; i < numOfItems; i++) {
            ProductDetailPage product = selectRandomItem();
            if (!products.contains(product.getItemName())) {
                products.add(product.getItemName());
                product.getAddToCartButton().click();
                items.add(new ItemModel(product.getItemName(), product.getItemPrice()));
            } else {
                i--;
                log.info("Item " + product.getItemName() + " is already in basket");
            }
        }
        log.info("Chosen products are: " + items);
        return items;
    }

    public CartPage goToCart() {
        clickOnElement(cart);
        return new CartPage(driver);
    }

    public String imageValue() {
        return itemImage.getAttribute("src");
    }

    public void logOut() {
        clickOnElement(burgerMenu);
        clickOnElement(logOut);
    }

    private ProductDetailPage selectRandomItem() {
        ProductDetailPage randomProduct = new ProductDetailPage(productList.get(getRandomElement(productList.size() - 1)));
        log.info("Random product is: " + randomProduct.getItemName());
        return randomProduct;
    }

    private void addToCart(ProductDetailPage productDetailPage) {
        clickOnElement(productDetailPage.getAddToCartButton());
    }
}



