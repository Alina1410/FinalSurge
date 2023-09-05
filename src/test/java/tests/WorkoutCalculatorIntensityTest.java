package tests;

import models.WorkoutCalculatorIntensity;
import models.WorkoutCalculatorIntensityFactory;
import org.testng.annotations.Test;

@Test
public class WorkoutCalculatorIntensityTest extends BaseTest {

    public void workoutCalculatorTest() {
        loginPage
                .open()
                .inputEmailAndPassword("vdufna@mailto.plus", "12345Alk")
                .clickSignInButton();
        platformSelectPage.selectPlatform();
        workoutCalculatorIntensityPage.openCalculators();
        WorkoutCalculatorIntensity workoutCalculatorIntensity= WorkoutCalculatorIntensityFactory.fillingCalculatorData();
        workoutCalculatorIntensityModalPage.fillInForm(workoutCalculatorIntensity);
    }
}