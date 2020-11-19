package Tests;

import Pages.SaucedemoLocatorsPage;
import Pages.SwagLabsLocatorsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceDemoPositiveLoginTest extends TestBase{
    SaucedemoLocatorsPage saucedemoLocatorsPage;
    SwagLabsLocatorsPage swagLabsLocatorsPage;

    //login data
//    @Parameterized.Parameter(0)
//    public String usernameParameter;
//    @Parameterized.Parameter(1)
//    public String passwordParameter;


//    @Parameterized.Parameters(name = "Test {index}: username: {0}, password: {1}")
//    public static Collection<Object[]> dataForRegistration() {
//        return Arrays.asList(new Object[][]{
//                {"standard_user", "secret_sauce"},
//                {"problem_user", "secret_sauce"},
//                {"performance_glitch_user", "secret_sauce"},
//        });
//    }

    @DataProvider(name = "data-provider")
    public Object [][] dataForRegistration() {
        return new Object[][] {
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}

        };
    }

    @Test(dataProvider = "data-provider")
    public void WhenAccurateDataPutShouldLogin (String username, String password) {
        saucedemoLocatorsPage = PageFactory.initElements(driver, SaucedemoLocatorsPage.class);
        saucedemoLocatorsPage.fillUsername(username);
        saucedemoLocatorsPage.fillPassword(password);
        saucedemoLocatorsPage.clickLoginButton();
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }


}