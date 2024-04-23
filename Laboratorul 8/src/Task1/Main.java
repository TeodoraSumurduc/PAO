package Task1;


///import Task2.calculatorResult.PrintResults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        List<List<String>> listOfLists = new ArrayList<>();
        List<String> tempList = new ArrayList<>();

        for (String str : args) {
            tempList.add(str);
            if (tempList.size() == 3) {
                listOfLists.add(new ArrayList<>(tempList));
                tempList.clear();
            }
        }
        DataBase db = new DataBase(url,user,ps);
        db.createTable();
        db.insertDataBase(listOfLists);
        ///SmarterCalculator.calculate(task2).stream().map(PrintResults::new).forEach(PrintResults::computeResult);
    }
}