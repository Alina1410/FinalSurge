package elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;


@Log4j2
public class Checkboxes {

    WebDriver driver;
    String id;

    public Checkboxes(WebDriver driver, String label) {
        this.driver = driver;
        this.id = label;
    }

    @Step("Tick checkbox as {isTrue}")
    public void tickCheckbox(boolean isTrue) {
        log.info("Tick checkbox " + isTrue);
        if (isTrue) {
            try {
                driver.findElement(By.id(id)).click();
            } catch (ElementClickInterceptedException e) {
                log.warn(e.getLocalizedMessage());
                WebElement element = driver.findElement(By.id(id));
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", element);
            }
        }
    }
}
