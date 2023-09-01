package pages;

import elements.DropDown;
import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.UserProfile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2

public class UserProfileModalPage extends BasePage {

    private static final By BIRTHDAY = By.id("BDay");
    public static final By PROFILE_MODAL_TITLE = By.xpath("//label[text()='Profile Picture']");

    public UserProfileModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Edit User profile")
    public UserProfilePage editProfile(UserProfile userProfile) {
        log.info("Add First Name to profile");
        new Input(driver, "fname").write(userProfile.getFirstName());
        log.info("Add Last Name to profile");
        new Input(driver, "lname").write(userProfile.getLastName());
        log.info("Select gender");
        new RadioButton(driver, "male").clickRadioButton(userProfile.getGender());
        log.info("Add Birthday to profile");
        new Input(driver, "BDay").clear(BIRTHDAY);
        new DropDown(driver, "Birthday").selectDropdownBday(userProfile.getBirthday());
        log.info("Add weight to profile");
        new Input(driver, "Weight").write(userProfile.getWeight());
        log.info("Choose weight measure in profile");
        new RadioButton(driver, "optionsRadios3").clickRadioButton(userProfile.getWeightMeasure());
        log.info("Select Country in profile");
        new DropDown(driver, "Country").selectOption(userProfile.getCountry());
        log.info("Select State/Region in profile");
        new DropDown(driver, "Region").selectOption(userProfile.getState());
        log.info("Add city to profile");
        new Input(driver, "City").write(userProfile.getCity());
        log.info("Add zip code to profile");
        new Input(driver, "Zip").write(userProfile.getZip());

        return new UserProfilePage(driver);
    }


    @Override
    public boolean isPageOpen() {
        return isExist(PROFILE_MODAL_TITLE);
    }
}

