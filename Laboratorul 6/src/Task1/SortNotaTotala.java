package Task1;

import java.util.Comparator;
import java.util.List;

public class SortNotaTotala implements Sortare {

    @Override
    public void sort(List<Student> studenti) {
        studenti.sort(Comparator.comparing(Student::getNotaTotala).reversed());
    }
}