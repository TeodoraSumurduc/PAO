package Task6;

import Task6.Dreptunghi;

public class Patrat extends Dreptunghi {

    public Patrat(int latura1){
        this.latura1=latura1;
        this.latura2=latura1;
        this.latura3=latura1;
        this.latura4=latura1;
        this.unghi1=90;
        this.unghi2=90;
        this.unghi3=90;
        this.unghi4=90;
    }

    @Override
    public int perimetru() {
        int result;
        result = latura1 + latura2 + latura3 + latura4;
        return result;
    }

    public double arie()
    {
        double result = latura1 * latura1;
        return result;
    }

}
