package Task2.calculatorResult;

import Task2.CalculationRequest;
import Task2.InvalidOperationException;

public abstract class CalculationResult {
    private final CalculationRequest request;

    public CalculationResult(CalculationRequest request) {
        this.request = request;
    }

    public CalculationRequest getRequest() {
        return request;
    }
    public abstract Object computeResult() throws InvalidOperationException;
}