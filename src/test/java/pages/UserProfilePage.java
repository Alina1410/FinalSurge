package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2

public class UserProfilePage extends BasePage {

    public static final By BREADCRUMB_LABEL = By.xpath("//a[contains( text(),'User Profile')]");
    public static final By SETTINGS_BUTTON = By.xpath("//a[contains( text(),'Settings')]");
    public static final By EDIT_PROFILE = By.xpath("//span[contains(text(),'Edit Profile')]");
    public static final By SAVE_EDIT_PROFILE = By.id("saveButtonProfile");


    public UserProfilePage(WebDriver driver) {
        super(driver);
    }


    @Step("Open Profile Page")
    public UserProfilePage clickSettingsButton() {
        driver.findElement(SETTINGS_BUTTON).click();
        log.info("Click sitting button");
        return new UserProfilePage(driver);
    }

    @Step("Open edit profile")
    public UserProfilePage openEditProfileForm() {
        driver.findElement(EDIT_PROFILE).click();
        log.info("Click edit profile button");
        return new UserProfilePage(driver);
    }

    @Step("Save profile's changes")
    public UserProfilePage clickSaveButton() {
        driver.findElement(SAVE_EDIT_PROFILE).click();
        log.info("Click save button in user profile page");
        return new UserProfilePage(driver);
    }

    @Step("Check that Profile page is opened")
    @Override
    public boolean isPageOpen() {
        log.info("Check that Profile page is opened");
        return isExist(EDIT_PROFILE);
    }


}
