package Task2;

import Task1.SortedListSet;

import java.util.*;
public class CounterWords implements WordCounter {
    private Map<String, Integer> counterWords;

    public CounterWords() {
        this.counterWords = new HashMap<>();
    }

    @Override
    public void parse(String text) {
        for (String cuv : text.split("[.,\\s+]")) {
            counterWords.put(cuv, counterWords.getOrDefault(cuv, 0) + 1);
        }
    }

    @Override
    public int getCount(String word) {
        return counterWords.getOrDefault(word, 0);
    }

    @Override
    public SortedSet<String> getUniqueWords() {
        SortedSet<String> uniqueWords = new TreeSet<>();
        for (Map.Entry<String, Integer> o : counterWords.entrySet()) {
            if (o.getValue() == 1)
                uniqueWords.add(o.getKey());
        }
        return uniqueWords;
    }

    @Override
    public void printWordCounts() {
        for (Map.Entry<String, Integer> entry : counterWords.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Override
    public void reset() {
        counterWords.clear();
    }
}

