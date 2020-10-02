package TestSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collection;

public class AllegroRegistrationTest {

    @RunWith(Parameterized.class)
    public class AllegroRegistrationPositiveTest {

        @Parameter()
        public String email;
        @Parameter(1)
        public String password;
        @Parameter(2)
        public String birthDay;
        @Parameter(3)
        public String birthMonth;
        @Parameter(4)
        public String birthYear;
        @Parameter(5)




        private WebDriver driver;
        private AllegroLocatorsPage allegroLocatorsPage;
        private WebDriverWait wait;






        @Parameters(name = "Test {index}: email: {0}, password: {1}, birthDay: {2}, birthMonth: {3}, birthYear {4}")

        public static Collection<Object[]> dataForRegisterOption() {

            return Arrays.asList(new Object[][]{
                    {"Gerwazy@pijaczek.com", "Pijacki80$", "25", "kwietnia", "1980", },


                    //todo write different data
                    {""},
                    {""},
            });
}
