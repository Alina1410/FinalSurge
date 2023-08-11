package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    static WebDriver driver;
    WebDriverWait wait;

    final String BASE_URL = "https://www.finalsurge.com/";


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public abstract boolean isPageOpen();

    public boolean isExist(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }


}
