package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void emailAndPasswordValidDate() {
        loginPage.open()
                .inputEmailAndPassword("vdufna@mailto.plus", "12345Alk")
                .clickSignInButton();
        boolean isPlatformSelectPageOpen = platformSelectPage.isPageOpen();

        Assert.assertTrue(isPlatformSelectPageOpen);

    }

    @DataProvider(name = "incorrectEmailPasswordData")
    public Object[][] inputIncorrectLoginTest() {
        return new Object[][]{
                {"", "", "Email is required"},
                {"vdufna@mailto.plus", "", "Password is required"},
                {"", "12345Alk", "Email is required"},
                {"vdufna@mailto.plus", "12345Al", "Invalid login credentials. Please try again."}

        };

    }

    @Test(dataProvider = "incorrectEmailPasswordData")
    public void negativEmailPassword(String email, String password, String errorMessage) {
        loginPage.open();
        loginPage.inputEmailAndPassword(email, password);
        loginPage.clickSignInButton();
        String error = loginPage.getPasswordErrorMessage();
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), error,
                "Текст сообщения неверный");
    }

    @Test
    public void checkLogInWithInvalidPassword() {
        loginPage
                .open()
                .inputEmailAndPassword("vdufna@mailto.plus", "")
                .clickSignInButton();
        String error = loginPage.getPasswordErrorMessage();
        Assert.assertEquals(error,
                "Password is required",
                "Неверный текс сообщения");
    }
}
