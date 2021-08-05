import Constants.LinksTitles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Locale;

public class BlogPage extends BasePage {
    private By links = By.xpath("//a[contains(@class,'tab-nav__item ng-scope')]");
    private By linksTitles = By.xpath("//a[contains(@class,'tab-nav__item ng-scope')]//span[@class='ng-binding']");

    SoftAssert sa = new SoftAssert();


    public void verifyAllLinksAreDisplayed() {
        if (getElements(links) != null) {
            for (WebElement element : getElements(links)) {
                sa.assertTrue(element.isDisplayed(), "link is not displayed");
            }
            sa.assertAll();
        }
    }

    public void verifyThatTittlesAreCorrect() {
        List<WebElement> titles = getElements(linksTitles);
        sa.assertTrue(titles.stream().map(element -> element.getText()).anyMatch(LinksTitles.REAL_STORIES.getValue()::equals), "Title " + LinksTitles.REAL_STORIES.getValue() + " is not displayed");
        sa.assertTrue(titles.stream().map(element -> element.getText()).anyMatch(LinksTitles.EVENTS.getValue()::equals), "Title " + (LinksTitles.EVENTS.getValue() + " is not displayed"));
        sa.assertTrue(titles.stream().map(element -> element.getText()).anyMatch(LinksTitles.MATERIALS.getValue()::equals), "Title " + (LinksTitles.MATERIALS.getValue() + " is not displayed"));
        sa.assertTrue(titles.stream().map(element -> element.getText()).anyMatch(LinksTitles.HARD_SKILLS.getValue()::equals), "Title " + (LinksTitles.HARD_SKILLS.getValue() + " is not displayed"));
        sa.assertTrue(titles.stream().map(element -> element.getText()).anyMatch(LinksTitles.NEWS.getValue()::equals), "Title " + (LinksTitles.NEWS.getValue() + " is not displayed"));
        sa.assertTrue(titles.stream().map(element -> element.getText()).anyMatch(LinksTitles.SOFT_SKILLS.getValue()::equals), "Title " + (LinksTitles.SOFT_SKILLS.getValue() + " is not displayed"));

        sa.assertAll();
    }
}
