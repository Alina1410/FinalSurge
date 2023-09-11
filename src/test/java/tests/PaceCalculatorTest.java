package tests;

import models.PaceCalculator;
import models.PaceCalculatorFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class PaceCalculatorTest extends BaseTest {

    @Test(description = "Using Pace Calculator to calculate paces")
    public void editProfilePageShouldBeOpened() {
        loginPage
                .open()
                .inputEmailAndPassword("vdufna@mailto.plus", "12345Alk")
                .clickSignInButton();
        platformSelectPage.selectPlatform();
        calendarPage.clickOtherCalculators();
        caloricNeedsCalculatorPage.clickPaceCalculatorButton();
        PaceCalculator paceCalculator = PaceCalculatorFactory.fillingPaceCalculatorForm();
        paceCalculatorModalPage.fillInForm(paceCalculator);

        Assert.assertTrue(paceCalculatorPage.titlePaceChartIsVisible(),
                "Форма Pace Calculator заполнена не верно");
    }

}