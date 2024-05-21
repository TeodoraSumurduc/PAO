package org.example.Task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SquarePower {

    private static List<Integer> generateNumbers(int count) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(random.nextInt(500));  // Am generat numere pana in 500 pentru a nu avea numere prea mari
        }
        return numbers;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        int nrThreads = Runtime.getRuntime().availableProcessors();

        int[] sizes = {10, 1000, 10000, 10000000};
        BufferedWriter writer = new BufferedWriter(new FileWriter("timing_results.txt", true));

        for (int size : sizes) {
            List<Integer> numbers = generateNumbers(size);
            int chunkSize = (int) Math.ceil((double) size / nrThreads);

            ExecutorService executor = Executors.newWorkStealingPool();
            List<CompletableFuture<Void>> futures = new ArrayList<>();

            long startTime = System.nanoTime();

            for (int i = 0; i < nrThreads; i++) {
                int start = i * chunkSize;
                int end = Math.min(start + chunkSize, size);

                List<Integer> subList = numbers.subList(start, end);

                futures.add(CompletableFuture.runAsync(() -> {
                    for (int number : subList) {
                        System.out.printf("%d^2=%d%n", number, number * number);
                    }
                }, executor));
            }

            for (CompletableFuture<Void> future : futures) {
                future.get();
            }

            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            writer.write(String.format("CompletableFuture, Size %d: %d ns%n", size, duration));
            writer.flush();

            executor.shutdown();
        }

    }
}
