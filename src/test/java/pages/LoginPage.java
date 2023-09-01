package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2


public class LoginPage extends BasePage {

    public static final By EMAIL_INPUT = By.xpath("//input[@tabindex='1']");
    public static final By PASSWORD_INPUT = By.xpath("//input[@tabindex='2']");
    public static final By SIGN_IN_BUTTON = By.xpath("//button[@type='submit']");
    public static final By EMAIL_ERROR_MESSAGE = By.xpath("//div[contains(text(),'Email is required')]");
    public static final By PASSWORD_ERROR_MESSAGE = By.xpath("//div[contains(text(),'Password is required')]");
    public static final By ERROR_MESSAGE = By.xpath("//div[@class='notification__content']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open the Login Page")
    public LoginPage open() {
        driver.get(BASE_URL + "login");
        log.info("Open Login page with URL: " + BASE_URL + "login");
        return this;
    }

    @Step("Enter Username or Email: '{email}' and Password: '{password}'")
    public LoginPage inputEmailAndPassword(String email, String password) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        log.info("Input the email in the field: " + email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        log.info("Input password in the field: " + password);
        return this;
    }

    @Step("Click on the Sign In button")
    public LoginPage clickSignInButton() {
        driver.findElement(SIGN_IN_BUTTON).click();
        log.info("Click on Sign In button with XPath: " + SIGN_IN_BUTTON);
        return this;
    }

    @Step("Get a email error message")
    public String getEmailErrorMessage() {
        log.info("Take the error message :" + EMAIL_ERROR_MESSAGE);
        return driver.findElement(EMAIL_ERROR_MESSAGE).getText();
    }

    @Step("Get a password error message")
    public String getPasswordErrorMessage() {
        log.info("Take the error message :" + PASSWORD_ERROR_MESSAGE);
        return driver.findElement(PASSWORD_ERROR_MESSAGE).getText();
    }

    @Step("Get an error message")
    public String getErrorMessage() {
        log.info("Take the error message :" + ERROR_MESSAGE);
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Checking to go to next page")
    @Override
    public boolean isPageOpen() {
        log.info("Find xpath: " + SIGN_IN_BUTTON);
        return isExist(SIGN_IN_BUTTON);

    }
}
