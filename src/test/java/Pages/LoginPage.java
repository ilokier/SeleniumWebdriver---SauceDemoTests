package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends BasePage {
    private static Logger log = LoggerFactory.getLogger("SauceDemoLocatorsPage.class");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#user-name")
    private WebElement username;
    @FindBy(css = "#password")
    private WebElement password;
    @FindBy(css = "#login-button")
    private WebElement loginButton;
    @FindBy(css = ".error h3")
    private WebElement loginError;


    public ProductsPage logIn(String userName, String passWord) {
        sendKeys(username, userName);
        sendKeys(password, passWord);
        loginButton.click();
        log.info("I'm logging in using credentials: " + userName + ", " + passWord);
        return new ProductsPage(driver);
    }


    public String getErrorMessage() {
        String attribute = loginError.getText();
        log.info("Error message is: " + attribute);
        return attribute;
    }


}