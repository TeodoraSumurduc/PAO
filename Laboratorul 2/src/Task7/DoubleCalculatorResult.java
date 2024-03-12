package Task7;

public class DoubleCalculatorResult extends CalculatorResult {
    public DoubleCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() {
        double left = (double) calculatorRequest.getLeftOperand();
        double right = (double) calculatorRequest.getRightOperand();
        switch (calculatorRequest.getOperation()) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return right != 0 ? left / right : null;
            default:
                return null;
        }
    }
}

