package Task4.requestMapper;

import Task4.CalculationRequest;

import java.util.Optional;

public final class IntegerCalculatorRequestMapper extends NumberCalculatorRequestMapper {
    @Override
    protected Optional<CalculationRequest> mapNumbers(String leftOperandString, String operatorString, String rightOperandString) {
        try {
            Integer leftOperand = Integer.parseInt(leftOperandString);
            Integer rightOperand = Integer.parseInt(rightOperandString);

            return Optional.of(new CalculationRequest(leftOperand, rightOperand, operatorString));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}