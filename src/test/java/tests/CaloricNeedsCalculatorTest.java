package tests;

import models.CaloricNeedsCalculator;
import models.CaloricNeedsCalculatorFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CaloricNeedsCalculatorModalPage;
import pages.CaloricNeedsCalculatorPage;

public class CaloricNeedsCalculatorTest extends BaseTest{
    @Test(description = "Using 'Other Calculators' to calculate pace")
    public void caloricCalculatorTest() {
        loginPage
                .open()
                .inputEmailAndPassword("vdufna@mailto.plus", "12345Alk")
                .clickSignInButton();
        platformSelectPage.selectPlatform();
        calendarPage.clickOtherCalculators();
        CaloricNeedsCalculator form = CaloricNeedsCalculatorFactory.getDataFromTheForm();
        caloricNeedsCalculatorModalPage.fillInForm(form);

        Assert.assertTrue(caloricNeedsCalculatorPage.titleCaloricNeedsCalculatorIsVisible(),
                "Форма Caloric Needs Calculator заполнена не верно");


    }
}
