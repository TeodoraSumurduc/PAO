package Task7;

public class BooleanCalculatorResult extends CalculatorResult {
    public BooleanCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() {
        boolean left = (boolean) calculatorRequest.getLeftOperand();
        boolean right = (boolean) calculatorRequest.getRightOperand();
        switch (calculatorRequest.getOperation()) {
            case "&&":
                return left && right;
            case "||":
                return left || right;
            default:
                return null;
        }
    }
}
