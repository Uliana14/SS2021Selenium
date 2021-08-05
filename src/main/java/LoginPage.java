import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BasePage {

    private By mailField = By.id("username");
    private By continueButton = By.id("kc-login-next");
    private By passwordField = By.id("password");
    private By toSignButton = By.id("kc-login");
    private By errorPath = By.xpath("//span[@class='error-text']");


    public LoginPage typeMail(String email) {
        getElement(mailField).sendKeys(email);
        return this;
    }

    public LoginPage continueButtonClick() {
        clickOnElement(continueButton);
        return this;
    }

    public LoginPage typePassword(String password) {
        getElement(passwordField).sendKeys(password);
        return this;
    }

    public ProfileHomePage sighInButtonClick() {
        clickOnElement(toSignButton);
        return new ProfileHomePage();
    }

    public void verifyThatUserFailedLogInWithIncorrectPassword() {
        Assert.assertTrue(getElement(errorPath).isDisplayed(), "Error is not displayed");
    }

    public void verifyThatSignInButtonIsNotEnabled() {
        Assert.assertFalse(getElement(continueButton).isEnabled(), "click button is enabled");
    }

    public void verifyThatSignInButtonIsEnabled() {
        Assert.assertTrue(getElement(continueButton).isEnabled(), "click button is disabled");

    }
}
