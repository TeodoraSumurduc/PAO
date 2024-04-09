package Task1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studenti = Arrays.asList(new Student("Aurel Vlaicu",5.3,7.8,9.0),new Student("Liviu Teodorescu", 7.7,5.2,9.0));

        /// strategy pattern pentru ca putem alege din cele 3 tipuri de sortari
        Sortare sortNotaTotala = new SortNotaTotala();
        Sortare sortNotaPartial = new SortNotaPartial();
        Sortare sortMediaNotelor = new SortMediaNotelor();

        // am utilizat si factory pattern cand am creeat clasele SortMediaNotelor, SortNotaPartial si SortNotaTotala
        // ca obiecte care implementează Sortare
        // aceste clase sunt fabricate si utilizate mai tarziu fara a fi necesara cunoastere implementarii lor interne

        System.out.println("Sortare după cea mai mare notă totală");
        sortNotaTotala.sort(new ArrayList<>(studenti));
        afisare(studenti);

        System.out.println("Sortare după nota partial");
        sortNotaPartial.sort(new ArrayList<>(studenti));
        afisare(studenti);

        System.out.println("Sortare dupa media notelor");
        sortMediaNotelor.sort(new ArrayList<>(studenti));
        afisare(studenti);

        }
        public static void afisare(List<Student> studenti){
            Integer i=1;
            for(Student s:studenti){
                System.out.println(i+"."+s.getNume()+" "+s.getNotaLaborator()+" "+s.getNotaPartial()+" "+s.getNotaExamen());
                i++;
            }
            System.out.println();
    }
}
