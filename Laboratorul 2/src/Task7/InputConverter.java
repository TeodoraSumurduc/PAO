package Task7;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class InputConverter {
    public static List<CalculatorRequest> mapRequests(String[] args) {
        List<CalculatorRequest> requests = new ArrayList<>();
        for (int i = 0; i < args.length; i += 3) {
            if (i + 2 < args.length) {
                try {
                    Object leftOperand;
                    Object rightOperand;
                    String operation = args[i + 1];

                    if (isInteger(args[i]) && isInteger(args[i + 2])) {
                        leftOperand = Integer.parseInt(args[i]);
                        rightOperand = Integer.parseInt(args[i + 2]);
                    } else if (isDouble(args[i]) && isDouble(args[i + 2])) {
                        leftOperand = Double.parseDouble(args[i]);
                        rightOperand = Double.parseDouble(args[i + 2]);
                    } else if (isBoolean(args[i]) && isBoolean(args[i + 2])) {
                        leftOperand = Boolean.parseBoolean(args[i]);
                        rightOperand = Boolean.parseBoolean(args[i + 2]);
                    } else {
                        // Ignorăm operațiile invalide
                        continue;
                    }

                    requests.add(new CalculatorRequest(leftOperand, rightOperand, operation));
                } catch (NumberFormatException e) {
                    // Ignorăm operațiile invalide
                }
            }
        }
        return requests;
    }

    private static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isBoolean(String value) {
        return value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false");
    }
}

