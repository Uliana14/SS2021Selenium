import Constants.BaseData;
import org.testng.annotations.*;

public class BlogTest extends BaseTest{

    @Test
    public void verifyThatAllLinksAreDisplayed() {
        new HomePage()
                .loadHomePage()
                .goToLoginPage();
        new LoginPage()
                .typeMail(BaseData.EMAIL.getValue())
                .continueButtonClick()
                .typePassword(BaseData.PASSWORD.getValue())
                .sighInButtonClick();
        new ProfileHomePage()
                .goToBlogPage()
                .verifyAllLinksAreDisplayed();
    }
    @Test
    public void verifyThatTitlesOnBlogPageAreCorrect() {
        new HomePage()
                .loadHomePage()
                .goToLoginPage();
        new LoginPage()
                .typeMail(BaseData.EMAIL.getValue())
                .continueButtonClick()
                .typePassword(BaseData.PASSWORD.getValue())
                .sighInButtonClick();
        new ProfileHomePage()
                .goToBlogPage()
                .verifyThatTittlesAreCorrect();
    }

}
