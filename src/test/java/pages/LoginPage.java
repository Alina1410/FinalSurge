package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public static final By LOGIN_IN_BUTTON=By.xpath("//button[@type='submit']");
    public static final By SIGN_IN_TITLE = By.xpath("//h1[contains(text(),'Sign In')]");
    public static final By EMAIL_INPUT = By.xpath("//input[@tabindex='1']");
    public static final By PASSWORD_INPUT = By.xpath("//input[@tabindex='2']");
    public static final By SIGN_IN_BUTTON = By.xpath("//button[@type='submit']");
    public static final By EMAIL_ERROR_MESSAGE = By.xpath("//div[contains(text(),'Email is required')]");
    public static final By PASSWORD_ERROR_MESSAGE = By.xpath("//div[contains(text(),'Password is required')]");
    public static final By ERROR_MESSAGE=By.xpath("//*[text()='Invalid login credentials. Please try again.']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open(){
        driver.get(BASE_URL+"login");
        return this;
    }

    public LoginPage inputEmailAndPassword(String email,String password){
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    public LoginPage clickSignInButton(){
        driver.findElement(SIGN_IN_BUTTON).click();
        return new LoginPage(driver);
    }

    public String getEmailErrorMessage(){
        return driver.findElement(EMAIL_ERROR_MESSAGE).getText();
    }

    public String getPasswordErrorMessage(){
        return driver.findElement(PASSWORD_ERROR_MESSAGE).getText();
    }

    public String getErrorMessage(){
        return driver.findElement(ERROR_MESSAGE).getText();
    }



    @Override
    public boolean isPageOpen() {
        return false;
    }
}
