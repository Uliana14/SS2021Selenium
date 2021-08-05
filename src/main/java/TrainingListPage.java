import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Locale;

public class TrainingListPage extends BasePage {
    private By searchField = By.xpath("//input[@name='training-filter-input']");
    private By bySkillsButton = By.xpath("//div[@class='drop-down-choose__header']//div[contains(text(),'By skills')]");
    private By searchCoursesBySkills = By.xpath("//div[contains(@class,'desktop')]//div[contains(@class,'training-item__title')]");
    private By noTrainingsMessage = By.xpath("//span[text()='No training are available.']");
    private By searchCoursesByLocation = By.xpath("//div[contains(@class,'desktop')]//span[contains(@class,'training-item__location')]|//div[contains(@class,'desktop')]//div[contains(@class,'training-item__location')]//div[contains(@class,'rd-tooltip-text')]");
    private By defaultLocationFilter = By.xpath("//span[contains(@class,'input-city-country')]");
    private By cleanDefaultLocationFilter = By.xpath("//span[@ng-click='checkCityLocation(location);']");
    private String locationCountry = "//li[@ng-repeat='locations in locationNames']//div[contains(text(),'%s')]";
    private String customCheckbox ="//div[contains(@class,'location__cities')]//label[normalize-space()='%s']/span";


    SoftAssert sa = new SoftAssert();


    public TrainingListPage goToSearchField() {
        clickOnElement(searchField);
        return this;
    }

    public TrainingListPage goToBySkillsButton() {
        clickOnElement(bySkillsButton);
        return this;
    }

    public TrainingListPage clickCheckbox(String value) {
        By checkbox = By.xpath(String.format(customCheckbox, value));
        clickOnElement(checkbox);
        return this;
    }


    public void verifyIfCheckboxIsUnchecked(String value) {
        By checkbox = By.xpath(String.format(customCheckbox, value));
        Assert.assertFalse(getElement(checkbox).isSelected(),"Checkbox is checked");
    }

    public void verifyThatSearchResultsContainsSearchCourse(String course) {
        if (getElements(searchCoursesBySkills) != null) {
            for (WebElement element : getElements(searchCoursesBySkills)) {
                sa.assertTrue(element.getText().contains(course.toUpperCase(Locale.ROOT)), "Incorrect course");
            }
            sa.assertAll();
        }
    }

    public void verifyThatSearchResultsContainsSearchLocation(String location, String anotherOneLocation) {
        if (getElements(searchCoursesByLocation) != null) {
            for (WebElement element : getElements(searchCoursesByLocation)) {
                sa.assertTrue(element.getText().contains(location) | element.getText().contains(anotherOneLocation), "Incorrect location");
            }
            sa.assertAll();
        }

    }

    public TrainingListPage cleanDefaultLocationFilters() {
        List<WebElement> defaultFilters = getElements(cleanDefaultLocationFilter);
        if (defaultFilters != null) {
            for (WebElement element : defaultFilters) {
                element.click();
            }
        }
        return this;
    }

    public boolean isMessageNoTrainingsDisplayed() {
        boolean isDisplayed = isDisplayed(noTrainingsMessage);
        return isDisplayed;
    }

    public void verifyFailedLoginErrorMessageDisplayed() {
        Assert.assertTrue(isMessageNoTrainingsDisplayed(),
                "'No Trainings available' error message is not displayed");
    }

    public TrainingListPage clickOnElement( String value) {
        By elementToBeClicked = By.xpath(String.format(locationCountry, value));
        clickOnElement(elementToBeClicked);
        return this;
    }
}
