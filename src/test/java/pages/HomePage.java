package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public static final By DASHBOARD_BUTTON = By.xpath("//*[@class='icsw16-home']");
    private static final By LOGOUT_LINK = By.xpath("//a[text()='Logout']");
    private static final By PRINT_WORKOUTS_LINK = By.xpath("//nav//li//i[@class='icsw16-printer']/..");
    private static final By REPORTS_STATISTICS_LINK = By.xpath("//a/i[@class='icsw16-graph']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get(BASE_URL + "/Default.cshtml");
        return this;
    }

    @Override
    public boolean isPageOpen() {
        return isExist(DASHBOARD_BUTTON);
    }

}
