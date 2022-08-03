package Tests.Helpers;

import Models.User;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserFactory extends BasePage {
    private static Logger log = LoggerFactory.getLogger("UserFactory.class");

    public UserFactory(WebDriver driver) {
        super(driver);
    }

    public User getRandomUser() {
        User randomUser = new User(getRandomFirstName(), getRandomlastName(), getRandomPostalCode());
        log.info("User data: " + randomUser);
        return randomUser;
    }
}
