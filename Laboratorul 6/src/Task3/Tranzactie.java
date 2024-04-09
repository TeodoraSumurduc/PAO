package Task3;

import java.time.Instant;

public class Tranzactie {
    protected Double sumaTransferata;
    protected String data;
    protected Client client;
    protected boolean trimis;

    public Tranzactie(Double sumaTransferata,Client client) {
        this.sumaTransferata = sumaTransferata;
        this.data = String.valueOf(Instant.now());
        this.client=client;
        this.trimis=client.getSumaCont(sumaTransferata);
    }
}
