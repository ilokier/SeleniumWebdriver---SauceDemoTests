package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucedemoLocatorsPage {

    public SaucedemoLocatorsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id = 'user-name']")
    private static WebElement username;
    @FindBy(xpath = "//input[@id = 'password']")
    private static WebElement password;
    @FindBy(xpath = "//input[@id = 'login-button']")
    private static WebElement loginButton;
    @FindBy(xpath = "//h3[contains(@data-test, 'error')]")
    private static WebElement loginError;



    public SaucedemoLocatorsPage logIn(String userName, String passWord) {
        username.sendKeys(userName);
        password.sendKeys(passWord);
        loginButton.click();
        return this;
    }

    public String getErrorMessage() {
        String attribute = loginError.getText();
        return attribute;
    }


}