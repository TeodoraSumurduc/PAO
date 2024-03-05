package lab1.task4;

import java.util.Objects;

public class DummyCalculator {
    public DummyCalculator() {
    }

    @Override
    public String toString() {
        return "DummyCalculator{}";
    }

    public boolean calculate(String[] args) {
        if (args.length != 3)
            System.out.printf("Eroare numar de parametri!");
        try {
            //operation for int
            int op1 = Integer.parseInt(args[0]);
            int op2 = Integer.parseInt(args[2]);
            System.out.printf(Integer.toString(operation(op1, op2, args[1])));

        } catch (NumberFormatException e) {
            try {
                //operation for double
                double op1 = Double.parseDouble(args[0]);
                double op2 = Double.parseDouble(args[2]);
                System.out.printf(Double.toString(operation(op1, op2, args[1])));

            } catch (NumberFormatException e2) {
                //operation for boolean
                boolean op1 = Boolean.parseBoolean(args[0]);
                boolean op2 = Boolean.parseBoolean(args[2]);
                System.out.printf(Boolean.toString(operation(op1, op2, args[1])));
            }
        }

        return false;
    }
    private int operation(int op1, int op2, String operator) {
        if (Objects.equals(operator, "+"))
            return op1 + op2;
        else if (Objects.equals(operator, "-"))
            return op1 - op2;
        else if (Objects.equals(operator, "/"))
            return op1 / op2;
        else if (Objects.equals(operator, "*"))
            return op1 * op2;
        else
            return op1 % op2;

    }
    private double operation(double op1, double op2, String operator) {
        if (Objects.equals(operator, "+"))
            return op1 + op2;
        else if (Objects.equals(operator, "-"))
            return op1 - op2;
        else if (Objects.equals(operator, "/"))
            return op1 / op2;
        else if (Objects.equals(operator, "*"))
            return op1 * op2;
        else
            return op1 % op2;

    }
    private boolean operation(boolean op1, boolean op2, String operator) {
        if (Objects.equals(operator, "&&"))
            return op1 && op2;
        return op1|op2;
}
}