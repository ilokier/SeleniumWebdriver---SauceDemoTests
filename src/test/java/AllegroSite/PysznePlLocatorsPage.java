package AllegroSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class PysznePlLocatorsPage {
    WebDriver driver;

    public PysznePlLocatorsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

     @FindBy(id = "imysearchstring")
    WebElement searchField;
    @FindBy(id = "submit_deliveryarea")
    WebElement searchButton;
    @FindBy(xpath ="//button[contains(@class, 'topbar__title')]")
   // @FindBy(xpath ="//div[@class='topbar__title-container']")
    WebElement foundAdress;




//    public void searchForBike() throws InterruptedException {
//         searchField.click();
//        public void typeSearchWord (String searchword)
//            searchField.sendKeys(searchword);
//        }
//        public void clickSearchButton() {
//            searchButton.click();
//        }
    public void SearchDozynkowa(){
        searchField.clear();
        searchField.sendKeys("dozynkowa lublin");
        searchButton.click();
    }

    public String CheckSearchWord(){
        String word = foundAdress.getText();
        LOGGER.info("word: "+word);
        return word;
            }

    public String getURL() {
        String URL = driver.getCurrentUrl();
        LOGGER.info("title: "+ URL);
        return URL;
    }

}
