package AllegroSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AllegroLocatorsPage {
    WebDriver driver;

 public AllegroLocatorsPage (WebDriver driver) {
     this.driver=driver;
     PageFactory.initElements(driver, this);
 }


}
