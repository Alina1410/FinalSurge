package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlatformSelectPage extends BasePage{

    public static final By SELECT_PLATFORM=By.xpath("//h1[@class='h4 mb-4']");

    public PlatformSelectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(SELECT_PLATFORM);
    }
}
