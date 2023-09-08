package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class PaceCalculatorPage extends BasePage{

    public final static By PACE_CALCULATOR_TITLE = By.xpath("//h4[text()='Pace Calculator']");
    public final static By RESULTS_PACE_CHART_LABEL=By.xpath("//h4[text()='Pace Chart']");
    public final static By ERROR_MESSAGE_PACE_CALCULATOR=By.xpath("//div[@class='alert alert-error']");

    public PaceCalculatorPage(WebDriver driver) {
        super(driver);
    }


    public boolean titlePaceChartIsVisible() {
        return driver.findElement(RESULTS_PACE_CHART_LABEL).isDisplayed();
    }


    @Step("Get a email error message")
    public String getPaceCalculatorErrorMessage() {
        log.info("Take the error message :" + ERROR_MESSAGE_PACE_CALCULATOR);
        return driver.findElement(ERROR_MESSAGE_PACE_CALCULATOR).getText();
    }

    @Step("PopUp Pace Calculator is visible")
    @Override
    public boolean isPageOpen() {
        return isExist(PACE_CALCULATOR_TITLE);
    }
}
