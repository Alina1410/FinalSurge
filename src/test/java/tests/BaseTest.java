package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected PlatformSelectPage platformSelectPage;
    protected UserProfilePage userProfilePage;
    protected UserProfileModalPage userProfileModalPage;
    protected PaceCalculatorModalPage paceCalculatorModalPage;


    @BeforeMethod
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        //options.addArguments("--start-maximized");
        //options.addArguments("--incognito");
        driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        userProfileModalPage = new UserProfileModalPage(driver);
        userProfilePage = new UserProfilePage(driver);
        platformSelectPage = new PlatformSelectPage(driver);
        paceCalculatorModalPage = new PaceCalculatorModalPage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}