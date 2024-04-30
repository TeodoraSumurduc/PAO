package Task2;

public class Main {
    public static void main(String[] args) {
        WordCounter wordCounter = new CounterWords();

        // Exemplu de text
        String text = "Acesta este un text de test care contine cuvinte repetitive. " +
                "Un text de test poate fi folosit pentru a verifica functionalitatea " +
                "clasei WordCounterImpl. Testul poate fi extins pentru a acoperi " +
                "mai multe scenarii.";

        // Parsăm textul și numărăm cuvintele
        wordCounter.parse(text);

        // Afișăm numărul de apariții pentru câteva cuvinte
        System.out.println("Numărul de apariții pentru cuvântul 'test': " + wordCounter.getCount("test"));
        System.out.println("Numărul de apariții pentru cuvântul 'text': " + wordCounter.getCount("text"));
        System.out.println("Numărul de apariții pentru cuvântul 'cuvinte': " + wordCounter.getCount("cuvinte"));

        // Afișăm toate cuvintele unice
        System.out.println("Cuvintele unice din text sunt: " + wordCounter.getUniqueWords());

        // Afișăm toate cuvintele și numărul lor de apariții
        System.out.println("Numărul de apariții pentru toate cuvintele:");
        wordCounter.printWordCounts();
    }
}

