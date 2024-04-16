package Task5;

import java.util.*;
import java.util.function.DoubleUnaryOperator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ///il citim pe n
        System.out.print("n= ");
        int n = scanner.nextInt();
        scanner.nextLine();
        ///citim cele n numere si le punem intr-o lista
        List<Double> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + ": ");
            if (scanner.hasNextDouble()) {
                numbers.add(scanner.nextDouble());
            } else {
                System.out.println("Nu e numar, deci se ignora");
                scanner.next();
                i--;
            }
        }
        ///operatiile posibile
        List<DoubleUnaryOperator> operations = Arrays.asList(
                num -> num * 2,                 ///inmultirea cu un scalar
                num -> num + 1,                 ///cresterea cu o unitate
                num -> 1.0 / num,               ///inversarea numarului
                num -> num * num,               ///ridicarea la patrat
                num -> Math.sin(num)     ///calcularea sinusului
        );

        ///aplicam o operatie aleatoare pe numerele citite
        numbers.forEach(num -> {
            DoubleUnaryOperator randomOperation = operations.get(new Random().nextInt(operations.size()));
            Double result = randomOperation.applyAsDouble(num);
            System.out.println(num + ": " + result);
        });

        // Închidem scannerul
        scanner.close();
    }
}
