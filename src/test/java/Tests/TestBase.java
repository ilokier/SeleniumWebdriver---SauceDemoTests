package Tests;

import Configuration.AppProperties;
import Configuration.DriverHandle;
import Pages.SauceDemoCartPage;
import Pages.SaucedemoLocatorsPage;
import Pages.SwagLabsLocatorsPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

import static java.lang.System.getProperty;

public class TestBase {
    protected static WebDriver driver;
    private static Logger log = LoggerFactory.getLogger("BaseTest.class");
    protected static DriverHandle driverHandle;
    private static AppProperties appProperties;
    final static String BASE_URL = "https://www.saucedemo.com/";
    protected SaucedemoLocatorsPage saucedemoLocatorsPage;
    protected SauceDemoCartPage sauceDemoCartPage;
    protected SwagLabsLocatorsPage swagLabsLocatorsPage;

    @BeforeSuite
    public void beforeAll(){
            appProperties = AppProperties.getInstance();
            driverHandle = new DriverHandle();
            driver = driverHandle.getDriver();
        driver.get(getProperty("appUrl"));
            log.info("<<<<<Driver initialized>>>");

        }



    @BeforeMethod
    public void setUp() {

       //sauceDemoCartPage = new SauceDemoCartPage(driver);
       //swagLabsLocatorsPage = new SwagLabsLocatorsPage(driver);
       saucedemoLocatorsPage = new SaucedemoLocatorsPage(driver);

    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
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
