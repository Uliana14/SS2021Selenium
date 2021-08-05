import Constants.BaseData;
import Constants.TestData.TestDataProvider;
import org.testng.annotations.*;

public class LoginTest extends BaseTest{

    @Test(description = "Verify user is successfully logged in with correct credentials")
    @Parameters({"emailForValidInput", "passwordForValidInput"})
    public void verifyUserIsSuccessfullyLoggedIn(String emailForValidInput, String passwordForValidInput) {
        new HomePage()
                .loadHomePage()
                .goToLoginPage();
        new LoginPage()
                .typeMail(emailForValidInput)
                .continueButtonClick()
                .typePassword(passwordForValidInput)
                .sighInButtonClick()
                .verifyUserNameIsDisplayed();
    }

    @Test(description = "Negative test: log in with incorrect password")
    @Parameters({"emailForInvalidInput", "passwordForInvalidInput"})
    public void verifyUserFailedLogInWithIncorrectPassword(String emailForInvalidInput, String passwordForInvalidInput) {
        new HomePage()
                .loadHomePage()
                .goToLoginPage();
        new LoginPage()
                .typeMail(emailForInvalidInput)
                .continueButtonClick()
                .typePassword(passwordForInvalidInput)
                .sighInButtonClick();
        new LoginPage()
                .verifyThatUserFailedLogInWithIncorrectPassword();
    }


    @Test(dataProvider = "invalidEmails", dataProviderClass = TestDataProvider.class)
    public void verifySignInButtonWithInvalidEmailIsNotEnabled(String email) {
        new HomePage()
                .loadHomePage()
                .goToLoginPage();
        new LoginPage()
                .typeMail(email)
                .verifyThatSignInButtonIsNotEnabled();
    }
    @Test(dataProvider = "validEmailBoundaryValues", dataProviderClass = TestDataProvider.class)
    public void verifySignInButtonWithValidEmailIsEnabled(String email) {
        new HomePage()
                .loadHomePage()
                .goToLoginPage();
        new LoginPage()
                .typeMail(email)
                .verifyThatSignInButtonIsEnabled();
    }
    @Test
    public void verifySignInButtonWithValidEmail() {
        new HomePage()
                .loadHomePage()
                .goToLoginPage();
        new LoginPage()
                .typeMail(BaseData.EMAIL.getValue())
                .verifyThatSignInButtonIsEnabled();
    }
}