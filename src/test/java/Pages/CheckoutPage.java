package Pages;

import Models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
}
