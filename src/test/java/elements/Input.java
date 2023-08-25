package elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2

public class Input {

    String inputLocator = "//div/input[@id='%s']";
    WebDriver driver;
    String label;
    WebDriverWait wait;
    String id;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(inputLocator,this.label))).clear();
        log.info("Clear input with label  " + this.label);
        driver.findElement(By.xpath(String.format(inputLocator, this.label))).sendKeys(text);
        log.info("Write into input with label " + this.label + "text: " + text);


    }

    public void clear(By locator) {
        log.info("clearing field");
        driver.findElement(locator).clear();
    }
    public void writeInProfileForm(String text) {
        driver.findElement(By.xpath(String.format(inputLocator, label))).sendKeys(text);
    }

}
