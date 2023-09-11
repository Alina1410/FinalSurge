package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.UserProfile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class UserProfilePage extends BasePage {

    public static final By EDIT_PROFILE = By.xpath("//span[contains(text(),'Edit Profile')]");
    String userProfileField = "//small[text()='%s:']/..";
    String birthday = "11/11/2000";

    public UserProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open edit profile")
    public UserProfilePage openEditProfileForm() {
        driver.findElement(EDIT_PROFILE).click();
        log.info("Click edit profile button with xpath:" + EDIT_PROFILE);
        return new UserProfilePage(driver);
    }

    @Step("Get value birthday")
    public String getBirDay() {
        return "Birthday: " + birthday;
    }

    @Step("Get text from User Profile field")
    public String getFieldValue(String label) {
        String textFromUserProfileField = driver.findElement(By.xpath(String.format(userProfileField, label))).getText();
        log.info("Get text from User Profile field by label: " + label);
        return textFromUserProfileField;
    }

    @Step("Check that Profile page is opened")
    @Override
    public boolean isPageOpen() {
        return isExist(EDIT_PROFILE);
    }


}
