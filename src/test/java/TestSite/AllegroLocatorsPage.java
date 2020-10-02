package TestSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AllegroLocatorsPage {
    private WebDriver driver;

    public AllegroLocatorsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //main page:
    @FindBy(xpath = "//span[contains(@class, 'mp7g_oh _1h7wt _9hx3e _1vx3o mpof_5r mpof_vs_l munh_8 munh_16_s munh_0_l mzmg_f9 _fee54_3DeiY')]")
    Select mojeAllegroDropdown;

    //registration form site:
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(xpath = "//label[contains(@for, 'day')]")
    WebElement birthDay;
    @FindBy(name = "month")
    Select birthMonth;
    @FindBy(id = "year")
    WebElement birthYear;


    //make metods:  class name and return this -> create fluent fill register forms:


    public void goToRegistrationForm() {
        mojeAllegroDropdown.selectByValue("register-button");

    }
}
