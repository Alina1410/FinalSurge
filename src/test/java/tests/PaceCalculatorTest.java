package tests;

import models.PaceCalculator;
import models.PaceCalculatorFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PaceCalculatorModalPage;

public class PaceCalculatorTest extends BaseTest{
    @Test(description = "Using 'Other Calculators' to calculate pace")
    public void paceCalculatorTest() {
        loginPage
                .open()
                .inputEmailAndPassword("vdufna@mailto.plus", "12345Alk")
                .clickSignInButton();
        platformSelectPage.selectPlatform();
        PaceCalculatorModalPage
                .open();
        PaceCalculator form = PaceCalculatorFactory.getDataFromTheForm();
        PaceCalculatorModalPage
                .fillInForm(form)
                .clickCalculateButton();
        Assert.assertTrue(paceCalculatorModalPage.paceChartTableIsVisible(), "Results table has not been opened");
    }
}
