package elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class RadioButton {

    String radioButtonInProfileForm = "%s";

    WebDriver driver;
    String id;

    public RadioButton(WebDriver driver, String label) {
        this.driver = driver;
        this.id = label;
    }

    @Step("Click on RadioButton")
    public void clickRadioButton() {
        driver.findElement(By.id(String.format(radioButtonInProfileForm,this.id))).click();
        log.info("Click with id" + this.id);
    }


}
