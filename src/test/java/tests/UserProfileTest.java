package tests;

import models.UserProfile;
import models.UserProfileFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

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

        assertEquals(userProfilePage.getFieldValue("City"),userProfile.getCity(),
                "Профиль не отредактирован");

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

