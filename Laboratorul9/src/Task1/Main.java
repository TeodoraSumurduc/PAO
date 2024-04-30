package Task1;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        SortedListSet<Integer> set = new SortedListSet<>();
        set.add(10);
        set.add(7);
        set.add(-3);
        set.add(29);
        set.add(29);
        set.add(-23);
        //sortam crecator
        Collections.sort(set,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }});
        System.out.println("Set-ul este sortat crescator: ");
        System.out.println(set);

        //afisam descrescator
        System.out.println("Set-ul este sortat descrescator: ");
        System.out.println(set.reversed());
        set = set.reversed();

        //afisam primul element
        System.out.println("Primul element:");
        System.out.println(set.first());

        //afisam subsetul de la -3 la 10
        System.out.println("Subsetul de la al doilea lement la penultimul:");
        System.out.println(set.subSet(set.get(1),set.get(set.size()-2)));

        //afisam ultimul element
        System.out.println("Ultimul element");
        System.out.println(set.last());

        //afisez pana la elemetul 7
        System.out.println("Subsetul pana la elementul 7");
        System.out.println(set.headSet(7));

        //afiseam dupa elementul 7
        System.out.println("Subsetul dupa elemetul 7");
        System.out.println(set.tailSet(7));
    }
}
