package Task1;

public class JustMyFirstException extends RuntimeException {

    // Constructor care folosește mesajul dorit
    public JustMyFirstException() {
        super("Oopsie! This is my first exception!");
    }

    // Constructor care aruncă excepția cu un mesaj prestabilit
    public JustMyFirstException(String message) {
        this();
    }
}
