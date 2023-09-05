package pages;

import elements.DropDown;
import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.CaloricNeedsCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CaloricNeedsCalculatorPage extends BasePage {

    public final static By OTHER_CALCULATORS_BUTTON = By.xpath("//i[@class='icsw16-calculator']");
    private final static By CALORIC_NEEDS_TITLE =
            By.xpath("//div[@class='w-box-header']/h4[text()='Daily Caloric Needs Calculator']");
    private final static By SAVE_BUTTON_CALORIC_NEEDS=By.id("saveButtonSettings");

    public CaloricNeedsCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Other Calculator page")
    public CaloricNeedsCalculatorPage openOtherCalculators() {
        driver.findElement(OTHER_CALCULATORS_BUTTON).click();
        log.info("Click on other calculators");
        return this;
    }

    public CaloricNeedsCalculatorPage clickSaveButton(){
        driver.findElement(SAVE_BUTTON_CALORIC_NEEDS).click();
        return new CaloricNeedsCalculatorPage(driver);
    }


    @Override
    public boolean isPageOpen() {
        return isExist(CALORIC_NEEDS_TITLE);
    }




}
