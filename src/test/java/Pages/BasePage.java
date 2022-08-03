package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Locale;
import java.util.Random;

public class BasePage {
    private static Logger log = LoggerFactory.getLogger("BasePage.class");
    protected WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private static Faker faker = new Faker(new Locale("pl-PL"));
    private String datePattern = "MM/dd/yyyy";
    private SimpleDateFormat format = new SimpleDateFormat(datePattern);

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(System.getProperty("webElementTimeOut"))));
        actions = new Actions(driver);

    }

    public String getRandomFirstName() {
        return faker.name().firstName();
    }

    public String getRandomlastName() {
        return faker.name().lastName();
    }

    public String getRandomPostalCode() {
        return faker.numerify("##-###");
    }

    public void clickOnElement(WebElement element) {
        waitForElement(element);
        element.click();
    }

    public void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void moveToElement(WebElement element) {
        actions.moveToElement(element).build().perform();
        waitForElement(element);
    }

    public void scrollAndClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        clickOnElement(element);

    }

    public void sendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public int getRandomElement(int index) {
        return new Random().nextInt(index);
    }

    public String getHeaderTitle() {
        String header = driver.findElement(By.cssSelector(".title")).getText();
        log.info(getClass() + ": " + "Actual header is: " + header);
        return header;
    }
}
