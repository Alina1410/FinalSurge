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

    public static final By PROFILE_MODAL_TITLE = By.xpath("//label[text()='Profile Picture']");

    public UserProfileModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Edit {userProfile}")
    public UserProfilePage editProfile(UserProfile userProfile) {
        new Input(driver, "fname").write(userProfile.getFirstName());
        new Input(driver, "lname").write(userProfile.getLastName());
        new RadioButton(driver, "male").clickRadioButton();
        new Input(driver, "BDay").inputBDay(userProfile.getBirthday());
        new Input(driver, "Weight").write(userProfile.getWeight());
        new RadioButton(driver, "optionsRadios3").clickRadioButton();
        new DropDown(driver, "Country").selectOption(userProfile.getCountry());
        new DropDown(driver, "Region").selectOption(userProfile.getState());
        new Input(driver, "City").write(userProfile.getCity());
        new Input(driver, "Zip").write(userProfile.getZip());

        return new UserProfilePage(driver);
    }

    @Step("Check that User Profile page is opened")
    @Override
    public boolean isPageOpen() {
        return isExist(PROFILE_MODAL_TITLE);
    }
}

