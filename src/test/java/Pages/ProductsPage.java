package Pages;

import Pages.ProductDetailPages.ProductDetailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductsPage extends BasePage {
    private static Logger log = LoggerFactory.getLogger("SwagLabsLocatorsPage.class");

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
    @FindBy(css = ".title")
    private WebElement headerTitle;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String addRandomItemToCart() {
        ProductDetailPage randomProduct = new ProductDetailPage(productList.get(getRandomElement(productList.size() - 1)));
        String chosenProduct = randomProduct.getItemName();
        log.info("Chosen product is: " + chosenProduct);
        clickOnElement(randomProduct.getAddToCartButton());
        return chosenProduct;
    }

    public CartPage goToCart() {
        clickOnElement(cart);
        return new CartPage(driver);
    }

    public String imageValue() {
        return itemImage.getAttribute("src");
    }

    public void logOut() {
        burgerMenu.click();
        waitForElement(logOut);
        logOut.click();
    }

    public String getHeaderTitle() {
        String header = headerTitle.getText();
        log.info("Header title is: " + header);
        return header;
    }
}



