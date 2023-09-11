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
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
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
    protected String email, password;

    @Step("Setting up and opening the browser")
    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        email = System.getenv().getOrDefault("FINAL_SURGE-EMAIL", PropertyReader.getProperty("finalsurge.email"));
        password = System.getenv().getOrDefault("FINAL_SURGE-PASSWORD", PropertyReader.getProperty("finalsurge.password"));
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