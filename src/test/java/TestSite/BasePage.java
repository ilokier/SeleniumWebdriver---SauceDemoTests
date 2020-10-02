package TestSite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    PysznePlLocatorsPage pysznePlLocatorsPage;
    WebDriverWait wait;
    GoogleLocatorsPage googlePage;
    AllegroLocatorsPage allegroPage;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "/home/lonia/Pulpit/szkolenia, materiały/projekty/Test/src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pysznePlLocatorsPage = new PysznePlLocatorsPage(driver);
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
        pysznePlLocatorsPage.SearchDozynkowa();
        Assertions.assertNotNull(pysznePlLocatorsPage.CheckSearchWord(), "not nul");
        Assertions.assertTrue(pysznePlLocatorsPage.CheckSearchWord().contains("%lublin%"));
    }

    @Test
    public void googleSearchForBikeTest() {
        driver.get("https://google.pl");

        //close pop up code:
        // TODO: 02.10.20 make pop up closed!
        try {
            //wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.out.println("Alert nie jest juz dostepny");
        }

        googlePage.searchForBike();

    }

    @Test
    public void openRegistrationFormTest() {
        driver.get("https://allegro.pl/");
        //close pop up code:
        //try {
        //wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        // } catch (Exception e) {
        //     System.out.println("Alert nie jest juz dostepny");
        //}
        allegroPage.goToRegistrationForm();
    }

//    @AfterEach
//    public void quitBrowser() {
//        driver.quit();
//    }

}







