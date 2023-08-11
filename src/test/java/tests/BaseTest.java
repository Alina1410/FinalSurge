package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;
import pages.PlatformSelectPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected PlatformSelectPage platformSelectPage;


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        platformSelectPage = new PlatformSelectPage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}