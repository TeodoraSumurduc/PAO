package Task7;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class SmarterCalculator {
    public static List<CalculatorResult> calculate(String[] args) {
        List<CalculatorResult> results = new ArrayList<>();
        List<CalculatorRequest> requests = InputConverter.mapRequests(args);

        for (CalculatorRequest request : requests) {
            switch (request.getRequestType()) {
                case "Boolean":
                    results.add(new BooleanCalculatorResult(request));
                    break;
                case "Integer":
                    results.add(new IntegerCalculatorResult(request));
                    break;
                case "Double":
                    results.add(new DoubleCalculatorResult(request));
                    break;
                default:
                    // Ignorăm cererile de tip necunoscut
                    break;
            }
        }

        return results;
    }
}
