package Pages;

import Models.User;
import org.openqa.selenium.WebDriver;

public class UserFaktory extends BasePage {
    User user;


    public UserFaktory(WebDriver driver) {
        super(driver);
    }

    public User getRandomUser() {
        User randomUser = new User(getRandomFirstName(), getRandomlastName(), getRandomPostalCode());
        return randomUser;
    }
}
