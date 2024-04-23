package Task4;


///import Task2.calculatorResult.PrintResults;

public final class Main {
    public static void main(String[] args) {
        args = new String[]{
                "1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "10.0", "/", "1"
        };

        runSmarterCalculator(args);
    }

    private static void runSmarterCalculator(String[] args) {
        String url = "jdbc:mysql://localhost:3306/laborator";
        String user = "student";
        String ps = "student";

        DataBase db = new DataBase(url,user,ps);
        db.deleteDuplicates();
        ///SmarterCalculator.calculate(task2).stream().map(PrintResults::new).forEach(PrintResults::computeResult);
    }
}