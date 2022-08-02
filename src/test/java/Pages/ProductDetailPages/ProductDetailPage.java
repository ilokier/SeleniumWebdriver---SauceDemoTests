package Pages.ProductDetailPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductDetailPage {
    private static Logger log = LoggerFactory.getLogger("ProductDetailPage.class");

    public ProductDetailPage(WebElement item) {
        PageFactory.initElements(new DefaultElementLocatorFactory(item), this);
    }

    @FindBy(css = ".inventory_item_name")
    private WebElement itemName;
    @FindBy(css = ".btn_primary")
    private WebElement addToCartButton;
    @FindBy(css = ".inventory_item_price")
    private WebElement itemPrice;
    @FindBy(css = ".cart_button")
    WebElement removeButton;

    public String getItemName() {
        return itemName.getText();
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public String getItemPrice() {

        return itemPrice.getText();
    }

    public WebElement getRemoveButton() {
        return removeButton;
    }
}
