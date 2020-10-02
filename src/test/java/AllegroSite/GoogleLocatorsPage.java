package AllegroSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleLocatorsPage {



    @FindBy(name = "q")
    WebElement googleSearchField;
    @FindBy(name = "div.btnk")
    WebElement szukajwGoogle;





    public void searchForBike(){
        googleSearchField.click();
        googleSearchField.sendKeys("bike");
        szukajwGoogle.click();
    }
}
