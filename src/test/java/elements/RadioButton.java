package elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2

public class RadioButton {

    String radioButtonInProfileForm = "//div/label/input[@id='%s']";

    WebDriver driver;
    String label;

    public RadioButton(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    @Step("Click on RadioButton")
    public void clickOnRadioButton(String gender) {
        driver.findElement(By.xpath(String.format(radioButtonInProfileForm, this.label))).click();
        log.info("Find xpath by label and click: " + radioButtonInProfileForm + " " + this.label);
    }
}
