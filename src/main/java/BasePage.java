import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BasePage {

    private WebDriverWait wait = new WebDriverWait(InitDriver.getDriver(), 50);
    private WebElement webElement;

    public void loadPage(String url) {
        InitDriver.getDriver().get(url);
    }

    public WebElement getElement(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webElement;
    }

    List<WebElement> getElements(By locator) {
        return InitDriver.getDriver().findElements(locator);
    }

    public void clickOnElement(By locator) {
        getElement(locator).click();
    }

    public void implicitWait(long timeToWait) {
        InitDriver.getDriver().manage().timeouts().implicitlyWait(timeToWait, TimeUnit.SECONDS);
    }

    public boolean isDisplayed(By locator) {
        try {
            return getElement(locator)
                    .isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

}
