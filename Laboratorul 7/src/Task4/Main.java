package Task4;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        IntStream.rangeClosed(2, n)
                .filter(num -> num % 2 == 0)
                .mapToObj(num -> new Pair(num, num * num))
                .forEach(System.out::println);
    }
}

class Pair {
    private int number;
    private int square;

    public Pair(int number, int square) {
        this.number = number;
        this.square = square;
    }

    @Override
    public String toString() {
        return "număr: " + number + ", Pătrat: " + square;
    }
}

