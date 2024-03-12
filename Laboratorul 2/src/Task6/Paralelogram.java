package Task6;

import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

public class Paralelogram extends Patrulater {
    public Paralelogram() {
    }

    public Paralelogram(int latura1, int latura2, int unghi1,int unghi2){
        this.latura1=latura1;
        this.latura2=latura2;
        this.latura3=latura1;
        this.latura4=latura2;
        this.unghi1=unghi1;
        this.unghi2=unghi1;
        this.unghi3=unghi2;
        this.unghi4=unghi2;
    }

    @Override
    public int perimetru() {
        int result;
        result = latura1 + latura2 + latura3 + latura4;
        return result;
    }

    public double arie()
    {
        double result = latura1 * latura2 * sin(toRadians(unghi1));
        return result;
    }

}
