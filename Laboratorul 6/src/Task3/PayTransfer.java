package Task3;

public class PayTransfer extends Tranzactie{

    public PayTransfer(Double sumaTransferata, Client client) {
        super(sumaTransferata, client);
    }

    @Override
    public String toString() {
        return "Task3.PayTransfer{" +
                "sumaTransferata=" + sumaTransferata +
                ", data='" + data + '\'' +
                ", client=" + client +
                ", trimis=" + trimis +
                '}';
    }
}
