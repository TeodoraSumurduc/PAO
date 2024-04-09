package Task2;

public class Main {
    public static void main(String[] args) {
        // Crearea utilizatorilor
        Utilizator adrian = new Utilizator("Adrian");
        Utilizator ion = new Utilizator("Ion");
        Utilizator maria = new Utilizator("Maria");
        Utilizator matei = new Utilizator("Matei");

        // Crearea topicurilor unde putem vedea prezenta patternului factory
        Topic programare = TopicFactory.getTopic("programare");
        Topic gatit = TopicFactory.getTopic("gatit");

        // Abonarea utilizatorilor la topicuri unde putem observa prezenta patternului observer
        programare.abonare(adrian);
        programare.abonare(ion);
        programare.abonare(maria);
        programare.abonare(matei);

        gatit.abonare(adrian);
        gatit.abonare(maria);

        // Trimiterea mesajelor
        programare.trimiteMesaj(ion, "Salutare!");
        gatit.trimiteMesaj(adrian, "Omlette du fromage");
    }
}
