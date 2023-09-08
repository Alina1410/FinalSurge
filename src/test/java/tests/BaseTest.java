package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import models.PaceCalculator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

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
        paceCalculatorModalPage=new PaceCalculatorModalPage(driver);
        paceCalculatorPage=new PaceCalculatorPage(driver);



    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}