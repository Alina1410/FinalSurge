package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class UserProfilePicturePage extends BasePage{

    public static final By CHANGE_IMAGE = By.id("EditProfilePicOther");
    public static final By SELECT_IMAGE_FILE=By.xpath("//input[@type='file']/../span");
    public static final By UPLOAD_BUTTON=By.id("NextStep");

    public UserProfilePicturePage(WebDriver driver) {
        super(driver);
    }

    public void downloadFile() {
        File file = new File("src/test/resources/Profile Picture.jpg");
        driver.findElement(CHANGE_IMAGE).click();
        driver.findElement(SELECT_IMAGE_FILE).sendKeys(file.getAbsolutePath());
        driver.findElement(UPLOAD_BUTTON).click();
    }



    @Override
    public boolean isPageOpen() {
        return false;
    }
}
