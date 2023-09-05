package pages;

import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import models.CaloricNeedsCalculator;
import org.openqa.selenium.WebDriver;

public class CaloricNeedsCalculatorModalPage extends BasePage{
    public CaloricNeedsCalculatorModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Filling Pace Calculator form")
    public static CaloricNeedsCalculatorPage fillInForm(CaloricNeedsCalculator caloricNeedsCalculator) {
       // new Input(driver, "Weight").writeCaloricNeeds(caloricNeedsCalculator.getWeight());
        new RadioButton(driver, "WeightType").clickRadioButton();
        new Input(driver, "HeightInchCent").write(caloricNeedsCalculator.getHeight());
        return new CaloricNeedsCalculatorPage(driver);
    }

    @Override
    public boolean isPageOpen() {
        return false;
    }
}
