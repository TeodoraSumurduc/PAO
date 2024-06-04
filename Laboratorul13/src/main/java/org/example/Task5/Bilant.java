package org.example.Task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Bilant implements Comparable<Bilant> {
    private int pozitive;
    private int negative;

    public Bilant() {
        this(0, 0);
    }

    public Bilant(int pozitive, int negative) {
        this.pozitive = pozitive;
        this.negative = negative;
    }

    @Override
    public int compareTo(Bilant other) {
        int thisDifference = this.pozitive - this.negative;
        int otherDifference = other.pozitive - other.negative;
        return Integer.compare(otherDifference, thisDifference);
    }

    @Override
    public String toString() {
        return "Bilant{pozitive=" + pozitive + ", negative=" + negative + "}";
    }

    public static void main(String[] args) {
        List<Bilant> bilanturi = new ArrayList<>();
        bilanturi.add(new Bilant(5, 3));
        bilanturi.add(new Bilant(2, 1));
        bilanturi.add(new Bilant(8, 4));

        List<Bilant> sortedBilanturi = bilanturi.stream()
                .sorted()
                .collect(Collectors.toList());

        sortedBilanturi.forEach(System.out::println);
    }
}
