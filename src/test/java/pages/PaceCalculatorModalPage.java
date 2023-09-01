package pages;

import elements.DropDown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.PaceCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class PaceCalculatorModalPage extends BasePage {

    public PaceCalculatorModalPage(WebDriver driver) {
        super(driver);
    }


    @Step("Filling Pace Calculator form")
    public static PaceCalculatorModalPage fillInForm(PaceCalculator paceCalculator) {
        new Input(driver, "RunDist").write(paceCalculator.getDistance());
        new DropDown(driver, "Kilometers").selectOption(paceCalculator.getDistance());
        new Input(driver, "TimeHH").write(paceCalculator.getHours());
        new Input(driver, "TimeMM").write(paceCalculator.getMinutes());
        new Input(driver, "TimeSS").write(paceCalculator.getSeconds());
        return new PaceCalculatorModalPage(driver);
    }

    @Override
    public boolean isPageOpen() {
        return false;
    }




}
