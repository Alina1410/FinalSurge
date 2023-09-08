package tests;

import models.WorkoutCalculatorIntensity;
import models.WorkoutCalculatorIntensityFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class WorkoutCalculatorIntensityTest extends BaseTest {

    public void workoutCalculatorTest() {
        loginPage
                .open()
                .inputEmailAndPassword("vdufna@mailto.plus", "12345Alk")
                .clickSignInButton();
        platformSelectPage.selectPlatform();
        calendarPage.clickWorkoutCalculators();
        WorkoutCalculatorIntensity workoutCalculatorIntensity= WorkoutCalculatorIntensityFactory.fillingCalculatorData();
        workoutCalculatorIntensityPage.fillInForm(workoutCalculatorIntensity);

        Assert.assertTrue(workoutCalculatorIntensityPage.titleYourWorkoutPacesIsVisible(),
                "Форма Pace Calculator заполнена не верно");
    }
}