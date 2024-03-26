package Task2;

import Task2.calculatorResult.CalculationResult;
import Task2.requestMapper.CalculatorRequestMapper;
import Task2.requestMapper.BooleanCalculatorRequestMapper;
import Task2.requestMapper.DoubleCalculatorRequestMapper;
import Task2.requestMapper.IntegerCalculatorRequestMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public final class InputConverter {

    private static final List<CalculatorRequestMapper> MAPPERS = Arrays.asList(new BooleanCalculatorRequestMapper(), new IntegerCalculatorRequestMapper(), new DoubleCalculatorRequestMapper());

    public static List<CalculationRequest> mapRequests(String[] args) throws InvalidArgumentsLengthException, UnknownOperandTypeException {
        if (args.length < 3 || args.length % 3 != 0) {
            throw new InvalidArgumentsLengthException("Invalid number of arguments");
        }

        List<CalculationRequest> calculatorRequests = new ArrayList<>();

        for (int i = 0; i < args.length; i += 3) {
            calculatorRequests.add(mapRequest(args[i], args[i + 1], args[i + 2]));
        }

        return calculatorRequests;
    }

    private static CalculationRequest mapRequest(String leftOperandString, String operatorString, String rightOperandString) throws UnknownOperandTypeException {
        for (CalculatorRequestMapper mapper : MAPPERS) {
            Optional<CalculationRequest> calculatorRequestOptional = mapper.tryMapRequest(leftOperandString, operatorString, rightOperandString);
            if (calculatorRequestOptional.isPresent()) {
                return calculatorRequestOptional.get();
            }
        }

        throw new UnknownOperandTypeException(leftOperandString + " " + operatorString + " " + rightOperandString);
    }
}
