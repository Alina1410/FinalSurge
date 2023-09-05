package pages;

import elements.Checkboxes;
import elements.DropDown;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import models.WorkoutQuickAdd;
import org.openqa.selenium.WebDriver;

public class WorkoutQuickAddModalPage extends BasePage {

    public WorkoutQuickAddModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Add workout through the quick add")
    public WorkoutQuickAddPage fillInFormQuickWorkout(WorkoutQuickAdd workoutQuickAdd) {
        new Input(driver, "WorkoutDate").write(workoutQuickAdd.getDate());
        new DropDown(driver, "WorkoutTime").selectOption(workoutQuickAdd.getTime());
        new DropDown(driver, "ActivityType").selectOption(workoutQuickAdd.getActivityType());
        new Input(driver, "Name").write(workoutQuickAdd.getWorkoutName());
        new TextArea(driver, "Desc").write(workoutQuickAdd.getWorkoutDescription());
        new Checkboxes(driver, "PlannedWorkout").tickCheckbox(workoutQuickAdd.isShowPlanned());
        if (workoutQuickAdd.isShowPlanned()) {
            new Input(driver, "PDistance").write(workoutQuickAdd.getPlannedDistance());
            new DropDown(driver, "PDistType").selectOption(workoutQuickAdd.getPlannedDistanceType());
            new Input(driver, "PDuration").write(workoutQuickAdd.getPlannedDuration());
        }
        new Input(driver, "Distance").write(workoutQuickAdd.getDistance());
        new DropDown(driver, "DistType").selectOption(workoutQuickAdd.getDistType());
        new Input(driver, "Duration").write(workoutQuickAdd.getDuration());
        new Input(driver, "Pace").write(workoutQuickAdd.getPace());
        new DropDown(driver, "PaceType").selectOption(workoutQuickAdd.getPaceType());
        new DropDown(driver, "HowFeel").selectOption(workoutQuickAdd.getHowIFelt());
        new DropDown(driver, "PerEffort").selectOption(workoutQuickAdd.getPerceivedEffort());
        new TextArea(driver, "PostDesc").write(workoutQuickAdd.getPostDesc());
        new Checkboxes(driver, "SaveLibrary").tickCheckbox(workoutQuickAdd.isSaveLibrary());


        return new WorkoutQuickAddPage(driver);

    }


    @Override
    public boolean isPageOpen() {
        return false;
    }
}
