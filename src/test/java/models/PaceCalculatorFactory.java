package models;

public class PaceCalculatorFactory {

    public static PaceCalculator getDataFromTheForm() {
        return  PaceCalculator.builder()
                .distance("8")
                .distType("Miles")
                .raceDist("Marathon")
                .hours("1")
                .minutes("10")
                .seconds("00")
                .build();
    }
}

