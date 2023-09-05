package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class WorkoutQuickAddPage extends BasePage{

    public static final By QUICK_ADD_WORKOUT_TITLE=By.id("WorkoutAddHeader");
    public static final By ADD_WORKOUT_BUTTON=By.id("saveButton");

    public WorkoutQuickAddPage(WebDriver driver) {
        super(driver);
    }

    @Step("Save quick workout")
    public WorkoutQuickAddPage clickSaveButton() {
        driver.findElement(ADD_WORKOUT_BUTTON).click();
        log.info("Click save button in user profile page");
        return new WorkoutQuickAddPage(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(QUICK_ADD_WORKOUT_TITLE);
    }
}
