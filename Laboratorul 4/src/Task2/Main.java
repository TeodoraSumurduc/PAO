package Task2;

import Task2.calculatorResult.CalculationResult;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        args = new String[]{
                "1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "10.0", "/", "0" // aici da eroare cand imparte la 0 :)))
        };

        runSmarterCalculator(args);
    }

    private static void runSmarterCalculator(String[] args) {
        try {
            List<CalculationResult> calculationResults = SmarterCalculator.calculate(args);

            for (CalculationResult result : calculationResults) {
                CalculationRequest request = result.getRequest();
                System.out.println("Operation " + request + " has result " + result.computeResult());
            }
        } catch (CalculatorException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}
