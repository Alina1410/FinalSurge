package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2
public class DropDown {

    String dropDownLocator = "%s";
    String optionDropDownInProfileForm = "//option[text()='%s']";
    String dropDownInPaceCalculator = "//select[@id='DistType']/option[text()='%s']";
    String dayLocator = "//td[text()='21']";

    WebDriver driver;
    String label;
    String id;

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.id = label;
    }

    public void selectOption(String option) {
        driver.findElement(By.id(String.format(dropDownLocator, this.id))).click();
        log.info("Click on dropdown with id " + this.id);
        driver.findElement(By.xpath(String.format(optionDropDownInProfileForm, option))).click();
        log.info("Select option " + option);
    }

    public void selectDropdownBday(String text) {
        driver.findElement(By.xpath(String.format(dayLocator, label))).click();
    }

}