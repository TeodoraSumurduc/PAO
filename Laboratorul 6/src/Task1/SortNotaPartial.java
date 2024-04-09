package Task1;

import java.util.Comparator;
import java.util.List;

public class SortNotaPartial implements Sortare {
    @Override
    public void sort(List<Student> studenti) {
        studenti.sort(Comparator.comparing(Student::getNotaPartial).reversed());
    }
}
