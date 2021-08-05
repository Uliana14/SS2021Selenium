import Constants.BaseData;
import org.openqa.selenium.By;


public class HomePage extends BasePage{
    private By signInButton = By.className("header-auth__signin-icon");


    public HomePage loadHomePage(){
        loadPage(BaseData.BASE_URL.getValue());
        return this;
    }
    public LoginPage goToLoginPage(){
    getElement(signInButton).click();
    return new LoginPage();
    }


}
