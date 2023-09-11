package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected PlatformSelectPage platformSelectPage;
    protected CalendarPage calendarPage;
    protected UserProfilePage userProfilePage;
    protected UserProfileModalPage userProfileModalPage;
    protected UserProfilePicturePage userProfilePicturePage;
    protected CaloricNeedsCalculatorPage caloricNeedsCalculatorPage;
    protected CaloricNeedsCalculatorModalPage caloricNeedsCalculatorModalPage;
    protected PaceCalculatorModalPage paceCalculatorModalPage;
    protected PaceCalculatorPage paceCalculatorPage;
    protected WorkoutCalculatorIntensityPage workoutCalculatorIntensityPage;
    protected WorkoutQuickAddPage workoutQuickAddPage;

    @Step("Setting up and opening the browser")
    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome")String browser) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        userProfileModalPage = new UserProfileModalPage(driver);
        userProfilePage = new UserProfilePage(driver);
        platformSelectPage = new PlatformSelectPage(driver);
        userProfilePicturePage = new UserProfilePicturePage(driver);
        caloricNeedsCalculatorPage = new CaloricNeedsCalculatorPage(driver);
        caloricNeedsCalculatorModalPage = new CaloricNeedsCalculatorModalPage(driver);
        workoutCalculatorIntensityPage = new WorkoutCalculatorIntensityPage(driver);
        calendarPage = new CalendarPage(driver);
        workoutQuickAddPage = new WorkoutQuickAddPage(driver);
        paceCalculatorModalPage = new PaceCalculatorModalPage(driver);
        paceCalculatorPage = new PaceCalculatorPage(driver);


    }

    @Step("Closing the browser")
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}