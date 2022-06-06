package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SwagLabsLocatorsPage extends BasePage {
    private static Logger log = LoggerFactory.getLogger("SwagLabsLocatorsPage.class");
    @FindBy(linkText = "Sauce Labs Backpack")
    private WebElement backpackItem;
    @FindBy(xpath = "//button[@class='btn_primary btn_inventory']")
    private WebElement addBackpackToCartButton;
    @FindBy(css = "svg[data-prefix='fas']")
    private WebElement cart;
    @FindBy(xpath = "//a[@id='item_4_img_link']/img")
    private WebElement itemImage;
    @FindBy(css = "#react-burger-menu-btn")
    private WebElement burgerMenu;
    @FindBy(css = "#logout_sidebar_link")
    private WebElement logOut;
    @FindBy(css = ".title")
    private WebElement headerTitle;

    public SwagLabsLocatorsPage(WebDriver driver) {
        super(driver);
    }


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



