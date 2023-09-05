package pages;

import elements.Input;
import elements.RadioButton;
import models.WorkoutCalculatorIntensity;
import org.openqa.selenium.WebDriver;

public class WorkoutCalculatorIntensityModalPage extends BasePage{
    public WorkoutCalculatorIntensityModalPage(WebDriver driver) {
        super(driver);
    }

    public WorkoutCalculatorIntensityPage fillInForm (WorkoutCalculatorIntensity workoutCalculatorIntensity){
      //  new RadioButton(driver, "MARATHON").clickRadioButton(workoutCalculatorIntensity.getSelectEvent());
        new Input(driver,"TimeMM").write(workoutCalculatorIntensity.getMinutes());
        new Input(driver,"TimeSS").write(workoutCalculatorIntensity.getSeconds());
        return new WorkoutCalculatorIntensityPage(driver);
    }

    @Override
    public boolean isPageOpen() {
        return false;
    }
}
