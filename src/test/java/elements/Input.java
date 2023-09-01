package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2

public class Input {

    String inputLocator = "%s";
    String inputLocatorInPaceCalculator = "//div/input[@id='%s']";
    WebDriver driver;
    String id;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.id = label;
    }

    public void write(String text) {
        driver.findElement(By.id(String.format(inputLocator, this.id))).clear();
        log.info("Clear input with id  " + this.id);
        driver.findElement(By.id(String.format(inputLocator, this.id))).sendKeys(text);
        log.info("Write into input with id " + this.id + "text: " + text);
    }

    public void clear(By locator) {
        driver.findElement(By.id(String.format(inputLocator, this.id))).clear();
    }


}




