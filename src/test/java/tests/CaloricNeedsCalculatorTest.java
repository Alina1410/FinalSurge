package tests;

import models.CaloricNeedsCalculator;
import models.CaloricNeedsCalculatorFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class CaloricNeedsCalculatorTest extends BaseTest {
    @Test(description = "Using Caloric Calculator to calculate caloric needs")
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
