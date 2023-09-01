package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test(description = "Check that validation is successful when entering a login and password")
    public void emailAndPasswordValidDate() {
        loginPage.open()
                .inputEmailAndPassword("vdufna@mailto.plus", "12345Alk")
                .clickSignInButton();
        boolean isPlatformSelectPageOpen = platformSelectPage.isPageOpen();

        Assert.assertTrue(isPlatformSelectPageOpen);

    }

    @Test(description = "leave the password field blank")
    public void blankPasswordField() {
        loginPage.open()
                .inputEmailAndPassword("vdufna@mailto.plus", "")
                .clickSignInButton();

        Assert.assertEquals(loginPage.getPasswordErrorMessage(), "Password is required",
                "Текст сообщения неверный или отсутствует");
    }

    @Test(description = "leave the email field blank")
    public void blankEmailField() {
        loginPage.open()
                .inputEmailAndPassword("", "12345Alk")
                .clickSignInButton();

        Assert.assertEquals(loginPage.getEmailErrorMessage(), "Email is required",
                "Текст сообщения неверный или отсутствует");
    }

    @Test(description = "invalid email")
    public void invalidEmail() {
        loginPage.open()
                .inputEmailAndPassword("vvvdufna@mailto.plus", "12345Alk")
                .clickSignInButton();

        Duration timeoutDuration = Duration.ofSeconds(60);
        WebDriverWait wait = new WebDriverWait(driver,timeoutDuration);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='notification__content']")));

        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid login credentials. Please try again.",
                "Текст сообщения неверный или отсутствует");
    }

    @Test(description = "invalid password")
    public void invalidPassword() {
        loginPage.open()
                .inputEmailAndPassword("vdufna@mailto.plus", "12345Alkkk")
                .clickSignInButton();

        Duration timeoutDuration = Duration.ofSeconds(60);
        WebDriverWait wait = new WebDriverWait(driver,timeoutDuration);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='notification__content']")));

        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid login credentials. Please try again.",
                "Текст сообщения неверный или отсутствует");
    }


}



