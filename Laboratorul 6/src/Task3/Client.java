package Task3;

public class Client {
    private String nume;
    private Double sumaCont;
    private String payMethod;

    public Client(String nume, Double sumaCont, String payMethod) {
        this.nume = nume;
        this.sumaCont = sumaCont;
        this.payMethod = payMethod;
    }

    public Client(String nume, Double sumaCont) {
        this.nume = nume;
        this.sumaCont = sumaCont;
        this.payMethod = "Aleatoriu";
    }

    public boolean getSumaCont(Double sumaTransferata)
    {
        if(this.sumaCont>sumaTransferata)
        {
            this.sumaCont = this.sumaCont - sumaTransferata;
            return true;
        }
        else return false;
    }

    public String getPayMethod() {
        return payMethod;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nume='" + nume + '\'' +
                ", sumaCont=" + sumaCont +
                ", payMethod='" + payMethod + '\'' +
                '}';
    }
}
