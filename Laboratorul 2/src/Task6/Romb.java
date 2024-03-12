package Task6;

import Task6.Paralelogram;

import static java.lang.Math.*;

public class Romb extends Paralelogram {
    public double diag1,diag2;
    public Romb(int latura1, double unghi1, double unghi2) {
        this.latura1=latura1;
        this.latura2=latura1;
        this.latura3=latura1;
        this.latura4=latura1;
        this.unghi1 = unghi1;
        this.unghi2 = unghi2;
        this.unghi3 = unghi1;
        this.unghi4 = unghi2;
        this.diag1 = sqrt(latura1*latura1 + latura1*latura1 + 2*latura1*latura1*cos(toRadians(unghi1)));
        this.diag2 =  sqrt(latura1*latura1 + latura1*latura1 + 2*latura1*latura1*cos(toRadians(unghi2)));
    }

    @Override
    public int perimetru() {
        int result;
        result = latura1 * 4;
        return result;
    }

    public double arie()
    {
        double result = (diag1*diag2)/2;
        return result;
    }
}
