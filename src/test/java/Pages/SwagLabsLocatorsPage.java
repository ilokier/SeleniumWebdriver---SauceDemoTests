package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsLocatorsPage {

    public SwagLabsLocatorsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Sauce Labs Backpack")
    WebElement backpackItem;
    @FindBy(xpath = "//button[@class='btn_primary btn_inventory']")
    WebElement addBackpackToCartButton;
    @FindBy(css = "svg[data-prefix='fas']")
    WebElement cart;
    @FindBy(xpath = "//a[@id='item_4_img_link']/img")
    WebElement itemImage;


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

    public String imageValue() {
        return itemImage.getAttribute("src");
    }

}



