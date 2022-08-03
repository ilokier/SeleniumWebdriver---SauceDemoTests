package Tests;

import Configuration.AppProperties;
import Configuration.DriverHandle;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import Tests.Steps.PositiveLoginStep;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import static java.lang.System.getProperty;

public class TestBase {
    public WebDriver driver;
    private static Logger log = LoggerFactory.getLogger("BaseTest.class");
    protected DriverHandle driverHandle;
    private static AppProperties appProperties;
    protected LoginPage loginPage;
    protected CartPage cartPage;
    protected ProductsPage productsPage;
    protected PositiveLoginStep positiveLoginStep;
    protected CheckoutPage checkoutPage;
    protected SoftAssert softAssert;


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
        checkoutPage = new CheckoutPage(driver);
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

//    protected void capture(String tesMethodName) {
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File src = ts.getScreenshotAs(OutputType.FILE);
//        File target = new File(getProperty("user.dir") + "src/main/resources/screenshots" + tesMethodName + ".png");
//        try {
//            FileUtils.copyFile(src, target);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
