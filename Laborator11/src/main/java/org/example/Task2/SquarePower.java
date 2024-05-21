package org.example.Task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SquarePower {

    private static List<Integer> generateNumbers(int count) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(random.nextInt(100));
        }
        return numbers;
    }

    public static void main(String[] args) throws IOException {
        int[] sizes = {10, 1000, 10000, 10000000};
        BufferedWriter writer = new BufferedWriter(new FileWriter("timing_results.txt", true));

        for (int size : sizes) {
            List<Integer> numbers = generateNumbers(size);
            long startTime = System.nanoTime();

            for (int number : numbers) {
                int square = number * number;
                System.out.printf("%d^2=%d%n", number, square);
            }

            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            writer.write(String.format("Sequential, Size %d: %d ns%n", size, duration));
            writer.flush();
        }

        writer.close();
    }
}
