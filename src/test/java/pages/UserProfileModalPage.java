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

    public static final By FIRST_NAME = By.id("fname");
    public UserProfileModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Edit User profile")
    public UserProfilePage editProfile(UserProfile userProfile) {
        log.info("Add First Name to profile");
        new Input(driver, "First Name").clear(FIRST_NAME);
        new Input(driver,"First name").writeInProfileForm(userProfile.getFirstName());
        log.info("Add Last Name to profile");
        new Input(driver, "Last Name").write(userProfile.getLastName());
        log.info("Select gender");
        new RadioButton(driver, "Gender").clickOnRadioButton(userProfile.getGender());
        log.info("Add Birthday to profile");
        new Input(driver,"Birthday").write(userProfile.getBirthday());
        log.info("Add weight to profile");
        new Input(driver, "Weight").write(userProfile.getWeight());
        log.info("Choose weight measure in profile");
        new RadioButton(driver, "optionsRadios4").clickOnRadioButton(userProfile.getWeightMeasure());
        log.info("Select Country in profile");
        new DropDown(driver, "Country").selectDropdown(userProfile.getCountry());
        log.info("Select State/Region in profile");
        new DropDown(driver, "State/Region").selectDropdown(userProfile.getState());
        log.info("Add city to profile");
        new Input(driver, "City").write(userProfile.getCity());
        log.info("Add zip code to profile");
        new Input(driver, "Zip/Postal Code").write(userProfile.getZip());

        return new UserProfilePage(driver);
    }



    @Override
    public boolean isPageOpen() {
        return false;
    }
}
