package org.example.Task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultiThreaded {
    private static List<Integer> generateNumbers(int count) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(random.nextInt(100));
        }
        return numbers;
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        int nrThreads = Runtime.getRuntime().availableProcessors();
        int[] sizes = {10, 1000, 10000, 10000000};

        BufferedWriter writer = new BufferedWriter(new FileWriter("timing_results.txt", true));

        for (int size : sizes) {
            List<Integer> numbers = generateNumbers(size);
            int chunkSize = (int) Math.ceil((double) size / nrThreads);

            List<Thread> threads = new ArrayList<>();

            long startTime = System.nanoTime();

            for (int i = 0; i < nrThreads; i++) {
                int start = i * chunkSize;
                int end = Math.min(start + chunkSize, size);

                List<Integer> subList = numbers.subList(start, end);

                Thread thread = new Thread(() -> {
                    for (int number : subList) {
                        System.out.printf("%d^2=%d%n", number, number * number);
                    }
                });

                threads.add(thread);
                thread.start();
            }

            for (Thread thread : threads) {
                thread.join();
            }

            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            writer.write(String.format("MultiThreaded, Size %d: %d ns%n", size, duration));
            writer.flush();
        }

        writer.close();
    }
}
