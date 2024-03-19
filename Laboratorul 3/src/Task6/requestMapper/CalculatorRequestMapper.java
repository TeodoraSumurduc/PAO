package Task6.requestMapper;

import Task6.CalculationRequest;

import java.util.Optional;

public interface CalculatorRequestMapper {
    Optional<CalculationRequest> tryMapRequest(
            String leftOperandString,
            String operatorString,
            String rightOperandString);
}