package org.example.Task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelStream {
    private static List<Integer> generateNumbers(int count) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(random.nextInt(500));
        }
        return numbers;
    }

    public static void main(String[] args) throws IOException {
        int[] sizes = {10, 1000, 10000, 10000000};

        BufferedWriter writer = new BufferedWriter(new FileWriter("timing_results.txt", true));

        for (int size : sizes) {
            List<Integer> numbers = generateNumbers(size);

            long startTime = System.nanoTime();

            numbers.parallelStream()
                    .forEach(number -> System.out.printf("%d^2=%d%n", number, number * number));

            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            writer.write(String.format("ParallelStream, Size %d: %d ns%n", size, duration));
            writer.flush();
        }

        writer.close();

    }
}
