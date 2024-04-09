package Task2;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private String nume;
    private ArrayList<Utilizator> abonati;

    public Topic(String nume) {
        this.nume = nume;
        this.abonati = new ArrayList<Utilizator>();
    }

    public void abonare(Utilizator utilizator){
        abonati.add(utilizator);
    }

    public void trimiteMesaj(Utilizator utilizator, String continut){
        for(Utilizator u : abonati) {
            if(!u.equals(utilizator))
            {
                u.trimiteNotificare(continut, this.nume, utilizator.getNume());
            }
        }
    }
}
