package models;

public class CaloricNeedsCalculatorFactory {

    public static CaloricNeedsCalculator getDataFromTheForm() {
        return  CaloricNeedsCalculator.builder()
                .weight("60")
                .weightType("kg")
                .height("170")
                .heightType("centimeters")
                .age("25")
                .gender("female")
                .runDistance("10")
                .runDistanceType("kilometers")
                .build();
    }
}

