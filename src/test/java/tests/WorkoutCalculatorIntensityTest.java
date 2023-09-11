package tests;

import models.WorkoutCalculatorIntensity;
import models.WorkoutCalculatorIntensityFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.*;


public class WorkoutCalculatorIntensityTest extends BaseTest {
    @Test(description = "Using Intensity Calculator to calculate paces")
    public void workoutCalculatorIntensityTest() {
        loginPage
                .open()
                .inputEmailAndPassword(email, password)
                .clickSignInButton();
        platformSelectPage.selectPlatform();
        calendarPage.clickWorkoutCalculators();
        WorkoutCalculatorIntensity workoutCalculatorIntensity = WorkoutCalculatorIntensityFactory.fillingCalculatorData();
        workoutCalculatorIntensityPage.fillInForm(workoutCalculatorIntensity);

        assertTrue(workoutCalculatorIntensityPage.titleYourWorkoutPacesIsVisible(),
                "Форма Pace Calculator заполнена не верно");
    }
}