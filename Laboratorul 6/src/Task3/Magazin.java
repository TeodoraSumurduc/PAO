package Task3;

import java.util.ArrayList;

public class Magazin {
    private String nume;
    private ArrayList<Tranzactie> list;

    public Magazin(String nume) {
        this.nume = nume;
        this.list = new ArrayList<Tranzactie>();
    }
    public boolean tranzactie(Double valoare, Client client){
        Tranzactie tr = null;
        ///aici se poate observa ca am folosit strategy pattern
        if(client.getPayMethod()=="Card"){
            tr = new PayCard(valoare,client);
        }else if(client.getPayMethod()=="Cash"){
            tr = new PayCash(valoare,client);
        }else if(client.getPayMethod()=="Transfer"){
            tr = new PayTransfer(valoare,client);
        }else {
            tr = new PayCard(valoare,client);
        }
        list.add(tr);
        return tr.trimis;
    }
    public void afisareTranzactie(){
        System.out.println(nume);
        for(Tranzactie t: list){
            System.out.println(t);
        }
    }
}
