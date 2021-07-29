import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

@Test(description = "Negative test: log in with incorrect password")
public void verifyUserFailedLogInWithIncorrectPassword() {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    driver.get("https://training.by/#!/Home?lang=en");
    WebElement signInButton = driver.findElement(By.className("header-auth__signin-icon"));
    signInButton.click();
    WebElement mailInput = driver.findElement(By.id("username"));
    mailInput.sendKeys("golovka.uliana@gmail.com");
    WebElement continueButton = driver.findElement(By.id("kc-login-next"));
    continueButton.click();
    WebElement passwordInput = driver.findElement(By.id("password"));
    passwordInput.sendKeys("1234567");
    WebElement toSignButton = driver.findElement(By.id("kc-login"));
    toSignButton.click();
    String errorMessage = driver.findElement(By.xpath("//span[@class='error-text']")).getAttribute("textContent");
    Assert.assertTrue(errorMessage!="null", "Error is not displayed");
    driver.quit();
}


    @Test(description = "Verify user is successfully logged in with correct credentials", enabled = false)
    public void verifyUserIsSuccessfullyLoggedIn() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://training.by/#!/Home?lang=en");
        WebElement signInButton = driver.findElement(By.className("header-auth__signin-icon"));
        signInButton.click();
        WebElement mailInput = driver.findElement(By.id("username"));
        mailInput.sendKeys("ivanhorintest@gmail.com");
        WebElement continueButton = driver.findElement(By.id("kc-login-next"));
        continueButton.click();
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("ivanhorintestPassword");
        WebElement toSignButton = driver.findElement(By.id("kc-login"));
        toSignButton.click();
        WebElement userName = driver.findElement(By.className("user-info__name"));
        Assert.assertTrue(userName.isDisplayed(), "Username is not displayed");
        driver.quit();
    }
}
