package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CalendarPage extends BasePage {

    public static final By SETTINGS_BUTTON = By.xpath("//a[contains( text(),'Settings')]");
    public static final By CALENDER_PAGE_TITLE = By.xpath("//span[text()='View, Edit and Add workouts.']");
    public static final By QUICK_ADD_BUTTON = By.id("QuickAddToggle");

    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Profile Page")
    public UserProfilePage clickSettingsButton() {
        driver.findElement(SETTINGS_BUTTON).click();
        log.info("Click sitting button");
        return new UserProfilePage(driver);
    }

    @Step("Open Quick Workout")
    public CalendarPage clickQuickAdd() {
        driver.findElement(QUICK_ADD_BUTTON).click();
        log.info("Click Quick Add button");
        return new CalendarPage(driver);
    }

    @Step("Calendar page is open")
    @Override
    public boolean isPageOpen() {
        return isExist(CALENDER_PAGE_TITLE);
    }
}
