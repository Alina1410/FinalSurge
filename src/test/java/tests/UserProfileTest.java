package tests;

import models.UserProfile;
import models.UserProfileFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserProfilePage;

public class UserProfileTest extends BaseTest {

    @Test(description = "Open edit profile page")
    public void editProfilePageShouldBeOpened() {
        loginPage
                .open()
                .inputEmailAndPassword("vdufna@mailto.plus", "12345Alk")
                .clickSignInButton();
        platformSelectPage.selectPlatform();
        userProfilePage
                .openProfilePage()
                .openEditProfileForm();
        UserProfile userProfile=UserProfileFactory.getFillingUserProfileForm();
        userProfileModalPage.editProfile(userProfile);

        Assert.assertTrue(userProfilePage.isPageOpen(), "Profile page wasn't opened");
    }

}

