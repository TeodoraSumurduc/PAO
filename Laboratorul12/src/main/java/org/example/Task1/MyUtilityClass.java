package org.example.Task1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

public class MyUtilityClass{
    public static <T> void printCollection(Collection<T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection is null");
        }
        System.out.println(collection);
    }
    public static <T> List<T> duplicateCollection(Collection<T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection is null");
        }
        List<T> duplicated = new ArrayList<>();
        for (T element : collection) {
            duplicated.add(element);
            duplicated.add(element);
        }
        return duplicated;
    }
    public static <T, U> U aggregate(Collection<T> collection, U initial, BiFunction<U, T, U> accumulator) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection is null");
        }
        if (accumulator == null) {
            throw new NullPointerException("Accumulator is null");
        }
        U result = initial;
        for (T element : collection) {
            result = accumulator.apply(result, element);
        }
        return result;
    }
}
