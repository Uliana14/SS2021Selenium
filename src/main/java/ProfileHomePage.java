import org.openqa.selenium.By;
import org.testng.Assert;

public class ProfileHomePage extends BasePage {
    private By trainingListLink = By.xpath("//ul[@class='main-nav__list']//a[contains(text(),'Training list')]");
    private By blogLink = By.xpath("//ul[@class='main-nav__list']//a[contains(@class,'news clic')]");
    private By userNamePath = By.className("user-info__name");

    public TrainingListPage goToTrainingListPage() {
        clickOnElement(trainingListLink);
        return new TrainingListPage();
    }

    public BlogPage goToBlogPage() {
        clickOnElement(blogLink);
        return new BlogPage();
    }
    public void verifyUserNameIsDisplayed(){
        Assert.assertTrue(isDisplayed(userNamePath), "Username is not displayed");
    }

}
