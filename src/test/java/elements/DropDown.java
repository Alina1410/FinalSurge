package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DropDown {

    String dropDownInProfileFormForBirthday = "//input[@id='%s']";
    String dropDownInProfileForm = "//select[@id='%s']";
    String DROPDOWN_IN_PACE_CALCULATOR = "//select[@id='DistType']/option[text()='%s']";

    WebDriver driver;
    String label;

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectDropdown(String option) {
        driver.findElement(By.xpath(String.format(dropDownInProfileForm, this.label))).click();
        log.info("Click on dropdown with label " + this.label);
        driver.findElement(By.xpath(String.format(dropDownInProfileForm,this.label))).click();
        log.info("Select option " + option);
    }
    public void selectDropdownInPaceCalculator(String text) {
        System.out.println(String.format("Writing text '%s' into DropDown with label %s", text, label));
        driver.findElement(By.xpath(String.format(DROPDOWN_IN_PACE_CALCULATOR, label))).click();
    }
}
