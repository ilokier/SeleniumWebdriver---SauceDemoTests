package Tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class TestBase {
    public static WebDriver driver;
    final static String BASE_URL = "https://www.saucedemo.com/";

  //  public TestBase(){
    //    initialize();
    //}

    @Before
    public void initialize() {
        PageFactory.initElements(driver,this);
        System.setProperty("webdriver.chrome.driver", "/home/lonia/Pulpit/szkolenia, materiały/projekty/Test/src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @After
    public void TeardownTest() {
      driver.quit();
    }
}
