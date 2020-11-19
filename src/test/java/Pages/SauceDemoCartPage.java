package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoCartPage {

public SauceDemoCartPage(WebDriver driver){
    PageFactory.initElements(driver, this);
}

    @FindBy(xpath = "//div[@class = 'inventory_item_name']")
    WebElement cartInventoryItem;
    @FindBy(xpath = "//button[@class='btn_secondary cart_button']")
    WebElement removeButton;
    @FindBy(id = "shopping_cart_container")
    WebElement cartItemsCounter;


    public String getItemText() {
        return cartInventoryItem.getText();
    }

    public SauceDemoCartPage removeItemFromCart() {
        removeButton.click();
        return this;
    }

    public String checkIfCartIsEmpty() {
        return cartItemsCounter.getText();
    }

}
