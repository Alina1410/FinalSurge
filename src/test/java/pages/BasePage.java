package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    static WebDriver driver;

    final String BASE_URL = "https://www.finalsurge.com/";


    public BasePage(WebDriver driver) {
        this.driver = driver;
        Duration timeoutDuration = Duration.ofSeconds(60);
        WebDriverWait wait = new WebDriverWait(driver,timeoutDuration);
    }

    public abstract boolean isPageOpen();

    @Step("Checking for locator presence")
    public boolean isExist(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }


}
