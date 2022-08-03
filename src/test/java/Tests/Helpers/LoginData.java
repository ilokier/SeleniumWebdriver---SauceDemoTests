package Tests.Helpers;

import org.testng.annotations.DataProvider;

import static java.lang.System.getProperty;

public class LoginData {
    @DataProvider(name = "badCredentials")
    public static Object[][] dataForRegistrationBad() {
        return new Object[][]{
                {getProperty("standard_username"), getProperty("incorrect_password")},
                {getProperty("incorrect_username"), getProperty("password")},
                {getProperty("incorrect_username"), getProperty("incorrect_password")}
        };
    }

    @DataProvider(name = "goodCredentials")
    public static Object[][] dataForRegistrationGood() {
        return new Object[][]{
                {getProperty("standard_username")},
                {getProperty("problem_username")},
                {getProperty("performance_username")}

        };
    }


}
