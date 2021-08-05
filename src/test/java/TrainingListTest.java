import Constants.BaseData;
import Constants.CourseTitles;
import Constants.LocationCity;
import Constants.LocationCountry;
import org.testng.annotations.Test;

public class TrainingListTest extends BaseTest{
    @Test
    public void verifyThatSearchResultsContainsSearchCourse(){
            new HomePage()
                    .loadHomePage()
                    .goToLoginPage();
            new LoginPage()
                    .typeMail(BaseData.EMAIL.getValue())
                    .continueButtonClick()
                    .typePassword(BaseData.PASSWORD.getValue())
                    .sighInButtonClick();
            new ProfileHomePage()
                    .goToTrainingListPage();
            new TrainingListPage()
                    .goToSearchField()
                    .goToBySkillsButton()
                    .clickCheckbox(CourseTitles.JAVA.getValue())
                    .verifyThatSearchResultsContainsSearchCourse(CourseTitles.JAVA.getValue());
    }
    @Test
    public void verifyThatCheckBoxIsUnchecked(){
        new HomePage()
                .loadHomePage()
                .goToLoginPage();
        new LoginPage()
                .typeMail(BaseData.EMAIL.getValue())
                .continueButtonClick()
                .typePassword(BaseData.PASSWORD.getValue())
                .sighInButtonClick();
        new ProfileHomePage()
                .goToTrainingListPage();
        new TrainingListPage()
                .goToSearchField()
                .goToBySkillsButton()
                .clickCheckbox(CourseTitles.JAVA.getValue())
                .clickCheckbox(CourseTitles.JAVA.getValue())
                .verifyIfCheckboxIsUnchecked(CourseTitles.JAVA.getValue());
    }
    @Test
    public void verifyMessageNoTrainingsAppears(){
        new HomePage()
                .loadHomePage()
                .goToLoginPage();
        new LoginPage()
                .typeMail(BaseData.EMAIL.getValue())
                .continueButtonClick()
                .typePassword(BaseData.PASSWORD.getValue())
                .sighInButtonClick();
        new ProfileHomePage()
                .goToTrainingListPage();
        new TrainingListPage()
                .goToSearchField()
                .goToBySkillsButton()
                .clickCheckbox(CourseTitles.RUBY.getValue())
                .verifyFailedLoginErrorMessageDisplayed();
    }

    @Test
    public void verifyThatSearchResultsContainsSearchLocation(){
        new HomePage()
                .loadHomePage()
                .goToLoginPage();
        new LoginPage()
                .typeMail(BaseData.EMAIL.getValue())
                .continueButtonClick()
                .typePassword(BaseData.PASSWORD.getValue())
                .sighInButtonClick();
        new ProfileHomePage()
                .goToTrainingListPage();
        new TrainingListPage()
                .cleanDefaultLocationFilters()
                .goToSearchField()
                .clickOnElement(LocationCountry.UKRAINE.getValue())
                .clickCheckbox(LocationCity.LVIV.getValue())
                .verifyThatSearchResultsContainsSearchLocation(LocationCountry.UKRAINE.getValue(),LocationCountry.MULTI_LOCATION.getValue());
    }

    }

