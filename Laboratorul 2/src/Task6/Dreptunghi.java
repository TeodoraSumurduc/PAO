package Task6;

public class Dreptunghi extends Paralelogram {
    public Dreptunghi(int latura1,int latura2){
        this.latura1=latura1;
        this.latura2=latura1;
        this.latura3=latura2;
        this.latura4=latura2;
        this.unghi1=90;
        this.unghi2=90;
        this.unghi3=90;
        this.unghi4=90;
    }

    public Dreptunghi() {

    }

    @Override
    public int perimetru() {
        int result;
        result = latura1 + latura2 + latura3 + latura4;
        return result;
    }

    public double arie()
    {
        double result = latura1 * latura3;
        return result;
    }

}
