package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class TestBase {
    public static WebDriver driver;
    final static String BASE_URL = "https://www.saucedemo.com/";

    @BeforeMethod
    public void setUp() {
        PageFactory.initElements(driver, this);
        initialize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public static void initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    public void capture(String tesMethodName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File("///home/lonia/Pulpit/szkolenia, materiały/projekty/SauceDemoTest/screenshots/" + tesMethodName + ".jpg");
        try {
            FileUtils.copyFile(source, target);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
