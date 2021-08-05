
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {


    @BeforeMethod
    public void beforeMethodInitDriver() {
        InitDriver.getDriver();
    }

    @AfterMethod
    public void afterMethodQuite() {
        InitDriver.quitDriver();
    }

}
