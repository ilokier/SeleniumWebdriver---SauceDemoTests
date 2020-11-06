package Pages;

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



public SaucedemoLocatorsPage logIn (String fillUsername, String fillPasword){
        username.sendKeys(fillUsername);
        password.sendKeys(fillPasword);
        loginButton.click();
        return this;
    }

    public String getErrorMessage() {
        String attribute = loginError.getText();
        return attribute;
    }


}