package Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverHandle {
    private static Logger log = LoggerFactory.getLogger("BrowserEnvironment.class");
    private WebDriver driver;
    private String browserName;

    public WebDriver getDriver() {
        this.browserName = System.getProperty("browserName");
        log.info("Chosen browserName: " + browserName);
        switch (this.browserName) {
            case "firefox":
                driver = getFireFoxDriver();
                break;
            case "edge":
                driver = getEdgeDriver();
                break;
            default:
                driver = getChromeDriver();
                break;
        }
        return this.driver;
    }

    private WebDriver getChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        chromeOptions.addArguments("start-maximized");
        return new ChromeDriver(chromeOptions);
    }

    private WebDriver getFireFoxDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(firefoxOptions);
    }

    private WebDriver getEdgeDriver() {
        EdgeOptions edgeOptions = new EdgeOptions();
        WebDriverManager.edgedriver().setup();
        edgeOptions.addArguments("start-maximized");
        return new EdgeDriver(edgeOptions);
    }

}
