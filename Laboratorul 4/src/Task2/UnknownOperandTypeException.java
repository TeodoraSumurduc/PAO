package Task2;

public class UnknownOperandTypeException extends CalculatorException {
    public UnknownOperandTypeException(String operation) {
        super("Unknown operand type for operation: " + operation);
    }
}
