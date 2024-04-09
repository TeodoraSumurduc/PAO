package Task3;

public class PayCard extends Tranzactie{
    public PayCard(Double sumaTransferata, Client client) {
        super(sumaTransferata, client);
    }

    @Override
    public String toString() {
        return "Task3.PayCard{" +
                "sumaTransferata=" + sumaTransferata +
                ", data='" + data + '\'' +
                ", client=" + client +
                ", trimis=" + trimis +
                '}';
    }
}
