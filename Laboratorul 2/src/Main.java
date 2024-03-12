import Task6.*;
import Task7.CalculatorRequest;
import Task7.CalculatorResult;
import Task7.SmarterCalculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Patrulater patrulater = new Patrulater(3,4,5,6,30,60,120,150);
        System.out.println("perimetru patrulater "+patrulater.perimetru());

        Paralelogram paralelogram = new Paralelogram(3,4,60,120);
        System.out.println("perimetru paralelogram "+paralelogram.perimetru());
        System.out.println("arie paralelogram "+paralelogram.arie());

        Romb romb = new Romb(5,60,120);
        System.out.println("perimetru romb "+romb.perimetru());
        System.out.println("arie romb "+romb.arie());

        Dreptunghi dreptunghi = new Dreptunghi(3,5);
        System.out.println("perimetru dreptunghi "+dreptunghi.perimetru());
        System.out.println("arie dreptunghi "+dreptunghi.arie());

        Patrat patrat = new Patrat(4);
        System.out.println("perimetru patrat "+patrat.perimetru());
        System.out.println("arie patrat "+patrat.arie());

        String[] input = {"1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "10.0", "/", "1"};

        List<CalculatorResult> calculationResults = SmarterCalculator.calculate(input);

        for (CalculatorResult result : calculationResults) {
            CalculatorRequest request = result.getRequest();
            System.out.println("Operation " + request + " has result " + result.computeResult());
        }
    }
}