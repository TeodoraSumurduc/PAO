package Task2;

public class Utilizator {
    private String nume;

    public Utilizator(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void trimiteNotificare(String continut, String numeTopic, String utilizatorTrimis){
        System.out.println("["+nume+"] "+utilizatorTrimis+" @ "+numeTopic+": "+continut);
    }
}
