package Tests;

import Configuration.AppProperties;
import Configuration.DriverHandle;
import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import Tests.Steps.PositiveLoginStep;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

import static java.lang.System.getProperty;

public class TestBase {
    protected WebDriver driver;
    private static Logger log = LoggerFactory.getLogger("BaseTest.class");
    protected DriverHandle driverHandle;
    private AppProperties appProperties;
    final static String BASE_URL = "https://www.saucedemo.com/";
    protected LoginPage loginPage;
    protected CartPage cartPage;
    protected ProductsPage productsPage;
    protected PositiveLoginStep positiveLoginStep;


    @BeforeSuite
    public void beforeAll() {
        appProperties = AppProperties.getInstance();
    }

    @BeforeMethod
    public void setUp() {
        driverHandle = new DriverHandle();
        driver = driverHandle.getDriver();
        log.info("<<<<<Driver initialized>>>");
        positiveLoginStep = new PositiveLoginStep(driver);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.get(getProperty("appUrl"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void capture(String tesMethodName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(getProperty("user.dir") + "src/main/resources/screenshots" + tesMethodName + ".jpg");
        try {
            FileUtils.copyFile(source, target);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
