package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkoutCalculatorIntensityPage extends BasePage{

    public static final By WORKOUT_CALCULATORS= By.xpath("//i[@class='icsw16-stop-watch']");

    public WorkoutCalculatorIntensityPage(WebDriver driver) {
        super(driver);
    }

    public WorkoutCalculatorIntensityPage openCalculators() {
        driver.findElement(WORKOUT_CALCULATORS).click();

        return this;
    }

    @Override
    public boolean isPageOpen() {
        return false;
    }
}
