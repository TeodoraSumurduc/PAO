package Task2.calculatorResult;

import Task2.CalculationRequest;
import Task2.InvalidOperationException;

public class BooleanCalculationResult extends CalculationResult {
    public BooleanCalculationResult(CalculationRequest request) {
        super(request);
    }

    @Override
    public Object computeResult() throws InvalidOperationException {
        CalculationRequest request = getRequest();
        Boolean leftOperand = (Boolean) request.getLeftOperand();
        Boolean rightOperand = (Boolean) request.getRightOperand();

        switch (request.getOperation()) {
            case "&&":
                return leftOperand && rightOperand;
            case "||":
                return leftOperand || rightOperand;
            default:
                throw new InvalidOperationException("Invalid operation for Boolean operands: " + request.getOperation());
        }
    }
}
