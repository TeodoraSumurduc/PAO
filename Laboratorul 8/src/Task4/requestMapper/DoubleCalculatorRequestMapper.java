package Task4.requestMapper;

import Task4.CalculationRequest;

import java.util.Optional;

public final class DoubleCalculatorRequestMapper extends NumberCalculatorRequestMapper {
    @Override
    protected Optional<CalculationRequest> mapNumbers(String leftOperandString, String operatorString, String rightOperandString) {
        try {
            Double leftOperand = Double.parseDouble(leftOperandString);
            Double rightOperand = Double.parseDouble(rightOperandString);

            return Optional.of(new CalculationRequest(leftOperand, rightOperand, operatorString));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
