package Tests.Steps;

import Pages.LoginPage;
import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;

import static java.lang.System.getProperty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PositiveLoginStep extends LoginPage {
    private LoginPage loginPage;
    private ProductsPage productsPage;

    public PositiveLoginStep(WebDriver driver) {
        super(driver);
    }

    public ProductsPage logStandardUser() {
        loginPage = new LoginPage(driver);
        productsPage = loginPage.logIn(getProperty("standard_username"), getProperty("password"));
        assertThat(productsPage.getHeaderTitle(), is(getProperty("productPageHeaderTitle")));
        return new ProductsPage(driver);
    }
}
