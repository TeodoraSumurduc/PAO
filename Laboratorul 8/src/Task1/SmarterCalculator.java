package Task1;

import Task1.calculatorResult.DoubleCalculationResult;
import Task1.calculatorResult.IntegerCalculationResult;
import Task2.calculatorResult.BooleanCalculationResult;
import Task2.calculatorResult.CalculationResult;

import java.util.List;
import java.util.stream.Collectors;

public final class SmarterCalculator {

    public static List<CalculationResult> calculate(String[] args) {
        return InputConverter.mapRequests(args)
                .stream()
                .map(SmarterCalculator::createCalculatorResponse)
                .collect(Collectors.toList());
    }

    private static CalculationResult createCalculatorResponse(CalculationRequest request) {
        return switch (request.getRequestType()) {
            case Boolean -> new BooleanCalculationResult(request);
            case Integer -> new IntegerCalculationResult(request);
            case Double -> new DoubleCalculationResult(request);
            default -> throw new IllegalArgumentException();
        };
    }
}
