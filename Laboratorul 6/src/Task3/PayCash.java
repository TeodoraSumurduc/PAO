package Task3;

public class PayCash  extends Tranzactie{

    public PayCash(Double sumaTransferata, Client client) {
        super(sumaTransferata, client);
    }

    @Override
    public String toString() {
        return "Task3.PayCash{" +
                "sumaTransferata=" + sumaTransferata +
                ", data='" + data + '\'' +
                ", client=" + client +
                ", trimis=" + trimis +
                '}';
    }
}
