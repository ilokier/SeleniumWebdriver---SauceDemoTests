package TestSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleLocatorsPage {
    WebDriver driver;


    //konstruktor
    public GoogleLocatorsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='q']")
    WebElement googleSearchField;
    @FindBy(xpath = "//input[@name='btnK']")
    WebElement szukajwGoogle;
    @FindBy(xpath = "//div[@id='introAgreeButton']")
    WebElement acceptCookies;

public void setAcceptCookies(){
    acceptCookies.click();
}

    public void searchForBike() {
        googleSearchField.click();
        googleSearchField.sendKeys("bike");
        szukajwGoogle.click();
    }
}
