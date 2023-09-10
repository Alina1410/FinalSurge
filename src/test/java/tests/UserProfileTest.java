package tests;

import models.UserProfile;
import models.UserProfileFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;


public class UserProfileTest extends BaseTest {


    @Test(description = "Open edit profile page")
    public void editProfilePageShouldBeOpened() {
        loginPage
                .open()
                .inputEmailAndPassword("vdufna@mailto.plus", "12345Alk")
                .clickSignInButton();
        platformSelectPage.selectPlatform();
        calendarPage.clickSettingsButton();
        userProfilePage
                .openEditProfileForm();
        UserProfile userProfile = UserProfileFactory.getFillingUserProfileForm();
        userProfileModalPage
                .editProfile(userProfile);

        assertEquals(userProfilePage.getBirDay(),userProfilePage.getFieldValue("Birthday"), "Профиль не отредактирован");

    }

    @Test(description = "Update Profile Picture")
    public void addPicture() {
        loginPage
                .open()
                .inputEmailAndPassword("vdufna@mailto.plus", "12345Alk")
                .clickSignInButton();
        platformSelectPage.selectPlatform();
        calendarPage.clickSettingsButton();
        userProfilePage.openEditProfileForm();
        userProfilePicturePage.uploadImage();
        userProfileModalPage.saveProfileChanges();

        assertNotEquals(userProfilePicturePage.getSrcNotPicture(),
                userProfilePicturePage.getAttributeProfilePicture(),"Фото в профиль не добавлено");


    }

    @Test(description = "Delete Profile Picture")
    public void deletePicture() {
        loginPage
                .open()
                .inputEmailAndPassword("vdufna@mailto.plus", "12345Alk")
                .clickSignInButton();
        platformSelectPage.selectPlatform();
        calendarPage.clickSettingsButton();
        userProfilePage
                .openEditProfileForm();
        userProfilePicturePage.removeImage();
        userProfileModalPage.saveProfileChanges();

        assertEquals(userProfilePicturePage.getSrcNotPicture(),
                userProfilePicturePage.getAttributeProfilePicture(),"Фото из профиля не удалено");


    }


}

