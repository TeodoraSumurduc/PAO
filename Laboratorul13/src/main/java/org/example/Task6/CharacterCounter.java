package org.example.Task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CharacterCounter {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java CharacterCounter <file-path> <character>");
            return;
        }

        String filePath = args[0];
        char characterToCount = args[1].charAt(0);

        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Integer>> futures = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                CharacterCountTask task = new CharacterCountTask(line, characterToCount);
                Future<Integer> future = executor.submit(task);
                futures.add(future);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        int totalCount = 0;
        for (Future<Integer> future : futures) {
            try {
                totalCount += future.get();
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Error processing a line: " + e.getMessage());
            }
        }

        executor.shutdown();

        System.out.println("Total occurrences of character '" + characterToCount + "': " + totalCount);
    }
}