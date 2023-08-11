package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage{

    public static final By SIGN_UP_TITLE= By.xpath("//h1[@class='h4']");





    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return false;
    }
}
