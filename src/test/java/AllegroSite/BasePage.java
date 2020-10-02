package AllegroSite;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    PysznePlLocatorsPage locatorsPage;
    WebDriverWait wait;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "/home/lonia/Pulpit/szkolenia, materiały/projekty/Test/src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        locatorsPage = new PysznePlLocatorsPage(driver);
    }

    @Test
    public void NavigateToSite() {
        driver.get("https://google.pl");
        driver.navigate().to("https://www.pyszne.pl/");
        driver.navigate().back();
        driver.navigate().forward();
        // driver.getCurrentUrl();
    }
    @Test
     public void searchForDozynkowaTest() {
        driver.navigate().to("https://www.pyszne.pl/");
//close pop up code:
      //  try {
        //    wait = new WebDriverWait(driver, 2);
          //  wait.until(ExpectedConditions.alertIsPresent());
            //Alert alert = driver.switchTo().alert();
            //alert.accept();
             //} catch (Exception e) {
            //System.out.println("Alert nie jest juz dostepny");
        //}
//String searchword = "bike";

        locatorsPage.SearchDozynkowa();
        Assertions.assertNotNull(locatorsPage.CheckSearchWord(), "not nul");
     Assertions.assertTrue(locatorsPage.CheckSearchWord().contains("%lublin%"));


    }

    @AfterEach
        public void quitBrowser () {
        driver.quit();
        }

}







