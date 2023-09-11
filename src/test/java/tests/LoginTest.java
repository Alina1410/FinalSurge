package tests;


import static org.testng.Assert.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import utils.PropertyReader;
import tests.base.TestListener;

public class LoginTest extends BaseTest {

    @Test(description = "Check that validation is successful when entering a login and password")
    public void emailAndPasswordValidDate() {
        loginPage.open()
                .inputEmailAndPassword(email, password)
                .clickSignInButton();

        assertTrue(platformSelectPage.labelSelectPlatformIsVisible(),"Пользователь не авторизован");

    }

    @Test(description = "leave the password field blank")
    public void blankPasswordField() {
        loginPage.open()
                .inputEmailAndPassword("vdufna@mailto.plus", "")
                .clickSignInButton();

        assertEquals(loginPage.getPasswordErrorMessage(), "Password is required",
                "Текст сообщения неверный или отсутствует");
    }

    @Test(description = "leave the email field blank")
    public void blankEmailField() {
        loginPage.open()
                .inputEmailAndPassword("", "12345Alk")
                .clickSignInButton();

        assertEquals(loginPage.getEmailErrorMessage(), "Email is required",
                "Текст сообщения неверный или отсутствует");
    }

    @Test(description = "invalid email")
    public void invalidEmail() {
        loginPage.open()
                .inputEmailAndPassword("vvvdufna@mailto.plus", "12345Alk")
                .clickSignInButton();

        assertEquals(loginPage.getErrorMessage(), "Invalid login credentials. Please try again.",
                "Текст сообщения неверный или отсутствует");
    }

    @Test(description = "invalid password")
    public void invalidPassword() {
        loginPage.open()
                .inputEmailAndPassword("vdufna@mailto.plus", "12345Alkkk")
                .clickSignInButton();

        assertEquals(loginPage.getErrorMessage(), "Invalid login credentials. Please try again.",
                "Текст сообщения неверный или отсутствует");
    }



}



