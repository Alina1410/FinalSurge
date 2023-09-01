package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2
public class PaceCalculatorPage extends BasePage {

    public final static By OTHER_CALCULATORS_BUTTON = By.xpath("//i[@class='icsw16-calculator']");
    public final static By PACE_CALCULATOR_BUTTON = By.xpath("//div/a[text()='Pace Calculator']");
    public final static By PACE_CALCULATOR_TITLE =
            By.xpath("//div[@class='w-box-header']/h4[text()='Pace Calculator']");
    public final static By CALCULATE_PACES_SAVE_BUTTON = By.id("saveButtonSettings");

    public PaceCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Other Calculator page")
    public PaceCalculatorPage openOtherCalculators() {
        driver.findElement(OTHER_CALCULATORS_BUTTON).click();
        log.info("Click on other calculators");
        return this;
    }

    @Step("Open Pace Calculator")
    public PaceCalculatorPage openPaceCalculators() {
        driver.findElement(PACE_CALCULATOR_BUTTON).click();
        log.info("Click Pace Calculator button");
        return new PaceCalculatorPage(driver);
    }

    @Step("Clicking 'Calculate Pace' button")
    public void clickCalculateButton() {
        log.info("clicking 'Calculate Pace' button");
        driver.findElement(CALCULATE_PACES_SAVE_BUTTON).click();
    }

    @Override
    public boolean isPageOpen() {
        return isExist(PACE_CALCULATOR_TITLE);
    }
}
