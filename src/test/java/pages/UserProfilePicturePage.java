package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

@Log4j2
public class UserProfilePicturePage extends BasePage {

    public static final By CHANGE_IMAGE = By.id("EditProfilePicOther");
    public static final By SELECT_IMAGE_FILE = By.xpath("//input[@name='profilepic']");
    public static final By UPLOAD_BUTTON = By.id("NextStep");
    public static final By UPDATE_PROFILE_IMAGE_TITLE = By.xpath("//h3[text()='Update Profile Picture']");
    public static final By UPLOADER_FRAME = By.id("uploader");
    public static final By REMOVE_IMAGE_BUTTON = By.id("del-pic");
    public static final By SUBMIT_DELETE_PHOTO_BUTTON = By.xpath("//a[@class='btn btn-primary']");
    String srcAttributeNotPicture = "https://log.finalsurge.com/img/default-profile60x60.png";

    public UserProfilePicturePage(WebDriver driver) {
        super(driver);
    }


    @Step("Update Profile Picture")
    public void uploadImage() {
        File file = new File("src/test/resources/Profile Picture.jpg");
        driver.findElement(CHANGE_IMAGE).click();
        log.info("Click Change Image with id:" + CHANGE_IMAGE);
        driver.switchTo().frame(driver.findElement(UPLOADER_FRAME));
        log.info("Switched to frame by id: " + UPLOADER_FRAME);
        WebElement element = driver.findElement(SELECT_IMAGE_FILE);
        element.sendKeys(file.getAbsolutePath());
        element.submit();
        driver.switchTo().defaultContent();
        driver.findElement(UPLOAD_BUTTON).click();
        log.info("Click Upload button by id: " + UPLOAD_BUTTON);

    }

    @Step("Remove image in User Profile ")
    public UserProfilePicturePage removeImage() {
        driver.findElement(REMOVE_IMAGE_BUTTON).click();
        wait.until(ExpectedConditions.elementToBeClickable(SUBMIT_DELETE_PHOTO_BUTTON)).click();
        return this;
    }

    public String getSrcNotPicture() {
        return srcAttributeNotPicture;}

    public String getAttributeProfilePicture() {
        WebElement profilePicture = driver.findElement(By.xpath("//img[@class='img-avatar']"));
        String srcAttribute = profilePicture.getAttribute("src");
        return srcAttribute;

    }


    @Step("Check that update image is opened")
    @Override
    public boolean isPageOpen() {
        return isExist(UPDATE_PROFILE_IMAGE_TITLE);
    }
}
