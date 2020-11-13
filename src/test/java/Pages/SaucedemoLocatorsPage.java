package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucedemoLocatorsPage {
   // private WebDriver driver;

    //constructor
    public SaucedemoLocatorsPage(WebDriver driver) {
        //this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //localizators
    @FindBy(xpath = "//input[@id = 'user-name']")
    private static WebElement username;
    @FindBy(xpath = "//input[@id = 'password']")
    private static WebElement password;
    @FindBy(xpath = "//input[@id = 'login-button']")
    private static WebElement loginButton;
    @FindBy(xpath = "//h3[contains(@data-test, 'error')]")
    private static WebElement loginError;


    public void fillUsername(String userName){
        username.sendKeys(userName);
    }
    public void fillPassword(String passWord){
        password.sendKeys(passWord);
    }
    public void clickLoginButton(){
        loginButton.click();
    }

    public String getErrorMessage() {
        String attribute = loginError.getText();
        return attribute;
    }


}