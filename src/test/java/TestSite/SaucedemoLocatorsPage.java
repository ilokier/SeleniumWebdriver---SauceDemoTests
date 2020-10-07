package TestSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucedemoLocatorsPage {
    private WebDriver driver;

    //konstruktor
    public SaucedemoLocatorsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //lokalizatory
    @FindBy(xpath = "//input[@id = 'user-name']")
    WebElement username;
    @FindBy(xpath = "//input[@id = 'password']")
    WebElement password;
    @FindBy(xpath = "//input[@id = 'login-button']")
    WebElement loginButton;
    @FindBy(xpath = "//h3[contains(@data-test, 'error')]")
    WebElement loginError;



    public SaucedemoLocatorsPage fillName(String fillUsername) {
        username.sendKeys(fillUsername);
        return this;
    }

    public SaucedemoLocatorsPage fillPasword(String fillPasword) {
        password.sendKeys(fillPasword);
        return this;
    }

    public SaucedemoLocatorsPage clickLogin() {
        loginButton.click();
        return this;
    }

    public String getErrorMessage(String error) {
        String attribute = loginError.getAttribute(error);
        return attribute;

    }


}