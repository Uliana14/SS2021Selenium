package Constants.TestData;

import org.testng.annotations.DataProvider;

import java.util.Collections;

    public class TestDataProvider {

        @DataProvider(name = "invalidEmails")
        public Object[][] invalidEmails() {
            return new Object[][]{
                    {"golovka.ulianagmail.com"},
                    {"@gmail.com"},
                    {"golovka.uliana@gmailcom"},
                    {(String.join("", Collections.nCopies(6, "ulianagolovka")) + ".@gmail.com")},
                    {"golovka.uliana@gmail.c"},
                    {"golovka.uliana@gmail.comcomcomcom"}
            };
        }

        @DataProvider(name = "validEmailBoundaryValues")
        public Object[][] validEmails() {
            return new Object[][]{
                    {(String.join("", Collections.nCopies(4, "ulianagolovkauli")) + ".@gmail.com")},
                    {"golovka.uliana@gmail.co"},
                    {"golovka.uliana@gmail.commmmmmmm"},
            };
        }

        @DataProvider(name = "validEmailData")
        public Object[][] validEmail() {
            return new Object[][]{
                    {"golovka.uliana@gmail.com"}
            };
        }

    }
