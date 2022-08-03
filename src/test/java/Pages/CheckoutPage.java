package Pages;

import Models.ItemModel;
import Models.User;
import Pages.ProductDetailPages.ProductDetailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutPage extends BasePage {
    @FindBy(css = "#first-name")
    private WebElement firstNameInput;
    @FindBy(css = "#last-name")
    private WebElement lastNameInput;
    @FindBy(css = "#postal-code")
    private WebElement postalCodeInput;
    @FindBy(css = "#continue")
    private WebElement continueButton;
    @FindBy(css = ".cart_item")
    private List<WebElement> cartItemList;
    @FindBy(css = ".summary_subtotal_label")
    private List<WebElement> itemCost;
    @FindBy(css = "summary_tax_label")
    private List<WebElement> taxCost;
    @FindBy(css = "summary_total_label")
    private List<WebElement> totalCost;
    @FindBy(css = "#finish")
    private WebElement finishButton;
    @FindBy(css = ".complete-header")
    private WebElement completeInfo;

    private static Logger log = LoggerFactory.getLogger("CheckoutPage.class");

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CheckoutPage fillUserData(User user) {
        sendKeys(firstNameInput, user.getName());
        sendKeys(lastNameInput, user.getLastName());
        sendKeys(postalCodeInput, user.getPostalCode());
        clickOnElement(continueButton);
        return this;
    }

    public List<ItemModel> getCheckoutProductList() {
        List<ItemModel> products = cartItemList.stream()
                .map(product -> new ItemModel(new ProductDetailPage(product).getItemName(), new ProductDetailPage(product).getItemPrice()))
                .collect(Collectors.toList());
        log.info("Checkout Overview item list: " + products);
        return products;
    }

    public String finishOrder() {
        clickOnElement(finishButton);
        return completeInfo.getText();
    }
}
