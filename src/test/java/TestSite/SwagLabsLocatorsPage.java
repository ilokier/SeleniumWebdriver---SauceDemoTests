package TestSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsLocatorsPage {
    private WebDriver driver;


    public SwagLabsLocatorsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // @FindBy(xpath = "//a[@id='item_4_title_link']")
    @FindBy(linkText = "Sauce Labs Backpack")
    WebElement backpackItem;
    @FindBy(xpath = "//button[@class = 'btn_primary btn_inventory']")
    WebElement addBackpackToCartButton;
    @FindBy(css = "svg[data-prefix='fas']")
    WebElement cart;
    //cart
    @FindBy(xpath = "//div[@class = 'inventory_item_name']")
    WebElement cartInventoryItem;
    @FindBy(xpath = "//button[@class = 'btn_secondary cart_button']")
    WebElement removeButton;


    public SwagLabsLocatorsPage pickBackpack() {
        backpackItem.click();
        return this;
    }

    public SwagLabsLocatorsPage addBackpackToCart() {
        addBackpackToCartButton.click();
        return this;
    }

    public SwagLabsLocatorsPage goToCart() {
        cart.click();
        return this;
    }

    public String getItemText() {
        return cartInventoryItem.getText();

    }

    public SwagLabsLocatorsPage removeItemFromCart() {
        removeButton.click();
        return this;
    }
}

//todo add localizators, create tests


