package org.example.Task1;

public class Person {
    private String nume;

    public Person(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "Person - " + nume;
    }
}
