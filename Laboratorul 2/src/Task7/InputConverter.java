package Task7;

import java.util.ArrayList;
import java.util.List;

public class InputConverter {
    public static List<CalculatorRequest> mapRequests(String[] args) {
        List<CalculatorRequest> requests = new ArrayList<>();
        for (int i = 0; i < args.length; i += 3) {
            if (i + 2 < args.length) {
                try {
                    Object leftOperand = Double.parseDouble(args[i]);
                    Object rightOperand = Double.parseDouble(args[i + 2]);
                    requests.add(new CalculatorRequest(leftOperand, rightOperand, args[i + 1]));
                } catch (NumberFormatException e) {
                    // Ignorăm operațiile invalide
                }
            }
        }
        return requests;
    }
}
