package Task7;

public class IntegerCalculatorResult extends CalculatorResult {
    public IntegerCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() {
        int left = (int) calculatorRequest.getLeftOperand();
        int right = (int) calculatorRequest.getRightOperand();
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
