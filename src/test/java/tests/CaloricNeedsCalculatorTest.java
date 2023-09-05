package tests;

import models.CaloricNeedsCalculator;
import models.CaloricNeedsCalculatorFactory;
import org.testng.annotations.Test;
import pages.CaloricNeedsCalculatorModalPage;
import pages.CaloricNeedsCalculatorPage;

public class CaloricNeedsCalculatorTest extends BaseTest{
    @Test(description = "Using 'Other Calculators' to calculate pace")
    public void paceCalculatorTest() {
        loginPage
                .open()
                .inputEmailAndPassword("vdufna@mailto.plus", "12345Alk")
                .clickSignInButton();
        platformSelectPage.selectPlatform();
        caloricNeedsCalculatorPage.openOtherCalculators();
        CaloricNeedsCalculator form = CaloricNeedsCalculatorFactory.getDataFromTheForm();
        CaloricNeedsCalculatorModalPage
                .fillInForm(form);


    }
}
