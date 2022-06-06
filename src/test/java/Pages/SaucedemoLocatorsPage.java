package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaucedemoLocatorsPage extends BasePage {
    private static Logger log = LoggerFactory.getLogger("SauceDemoLocatorsPage.class");

    public SaucedemoLocatorsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id = 'user-name']")
    private static WebElement username;
    @FindBy(xpath = "//input[@id = 'password']")
    private static WebElement password;
    @FindBy(xpath = "//input[@id = 'login-button']")
    private static WebElement loginButton;
    @FindBy(xpath = "//h3[contains(@data-test, 'error')]")
    private static WebElement loginError;


    public SwagLabsLocatorsPage logIn(String userName, String passWord) {
        sendKeys(username, userName);
        sendKeys(password, passWord);
        loginButton.click();
        log.info("I'm logging in using credentials: " + userName + ", " + passWord);
        return new SwagLabsLocatorsPage(driver);
    }


    public String getErrorMessage() {
        String attribute = loginError.getText();
        log.info("Error message is: " + attribute);
        return attribute;
    }


}