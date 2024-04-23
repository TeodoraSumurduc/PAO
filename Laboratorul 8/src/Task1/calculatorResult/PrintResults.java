package Task1.calculatorResult;

import Task1.CalculationRequest;
import Task2.calculatorResult.CalculationResult;

public class PrintResults implements CalculationResult {

    private final CalculationResult calculationResult;

    public PrintResults(CalculationResult calculationResult) {
        this.calculationResult = calculationResult;
    }

    @Override
    public Object computeResult() {
        Object result = calculationResult.computeResult();
        CalculationRequest request = calculationResult.getRequest();
        System.out.println("Operation " + request + " has result " + result);
        return result;
    }

    @Override
    public CalculationRequest getRequest() {
        return calculationResult.getRequest();
    }
}