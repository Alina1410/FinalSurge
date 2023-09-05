package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

@Log4j2
public class UserProfilePicturePage extends BasePage {

    public static final By CHANGE_IMAGE = By.id("EditProfilePicOther");
    public static final By SELECT_IMAGE_FILE = By.xpath("//input[@name='profilepic']");
    public static final By UPLOAD_BUTTON = By.id("NextStep");
    public static final By UPDATE_PROFILE_IMAGE_TITLE = By.xpath("//h3[text()='Update Profile Picture']");

    public UserProfilePicturePage(WebDriver driver) {
        super(driver);
    }

    @Step("Update Profile Picture")
    public void uploadFile() {
        File file = new File("src/test/resources/Profile Picture.jpg");
        driver.findElement(CHANGE_IMAGE).click();
        log.info("Click Change Image with id:" + CHANGE_IMAGE);
        driver.findElement(SELECT_IMAGE_FILE).sendKeys(file.getAbsolutePath());
        log.info("Select image with xpath:" + SELECT_IMAGE_FILE);
        driver.findElement(UPLOAD_BUTTON).click();
        log.info("Click upload image with id:" + UPLOAD_BUTTON);
    }

    @Step("Check that update image is opened")
    @Override
    public boolean isPageOpen() {
        return isExist(UPDATE_PROFILE_IMAGE_TITLE);
    }
}
