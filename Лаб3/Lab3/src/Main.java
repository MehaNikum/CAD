import static java.lang.Math.*;
public class Main {
    public static double Integral(double a, double b, double step) {
        return (calculation(a,b,step));
    }
    public static double calculation(double a, double b, double step) {
        double h = b - a;
        double stepCount = 0;
        if((h/step) % 1 == 0){ stepCount = h / step; }
        else{ stepCount = floor(h / step); }  //2  //2.5
        double left = a;
        double right = a + step;
        double res = 0.0;
        for(double i = 0; i <= stepCount ; i++) {
            double a1 = integral(left);
            double b1 = integral(right);
            res = res + square(step,a1,b1);
            left = left + step;
            if(b < (right + step)){break;}
            right = right + step;
        }
        if(b < (right + step)){
            right = b;
            step = b - left;
            double a1 = integral(left);
            double b1 = integral(right);
            res = res + square(step,a1,b1);
        }
        return res;
    }
    public static double integral(double a) {
        //return (double) 2 / 3 * sqrt(pow(a,3));
        return  sqrt(a);
    }
    public static double square(double h, double a, double b){
        return (double) 1 / 2 * h * (a + b);
        //return b - a;
    }
}