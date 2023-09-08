package tests;

import models.WorkoutQuickAdd;
import models.WorkoutQuickAddFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkoutQuickAddTest extends BaseTest {

    @Test
    public void addQuickWorkout() {
        loginPage
                .open()
                .inputEmailAndPassword("vdufna@mailto.plus", "12345Alk")
                .clickSignInButton();
        platformSelectPage.selectPlatform();
        calendarPage.clickQuickAdd();
        WorkoutQuickAdd workoutQuickAdd = WorkoutQuickAddFactory.fillWorkoutQuickData();
        workoutQuickAddPage.fillInFormQuickWorkout(workoutQuickAdd);
        workoutQuickAddPage.clickSaveButton();

        Assert.assertTrue(workoutQuickAddPage.isPageOpen(), "Workout quick add wasn't opened");

    }
}