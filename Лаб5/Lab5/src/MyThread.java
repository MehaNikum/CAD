import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

public class MyThread implements Runnable{
    double a;
    double b;
    double step;
    double h;
    double stepCount = 0;
    double left;// = a;
    double right;// = a + step;
    double res = 0.0;
    Res result;
    public MyThread(double a, double b, double step, double h, Res result){
        this.a = a;
        this.b = b;
        this.step = step;
        this.h = h;
        this.result = result;
        this.left = a;
        this.right = a + step;
    }

    @Override
    public void run() {

        if((h/step) % 1 == 0){ stepCount = h / step; }
        else{ stepCount = floor(h / step); }  //2  //2.5

        for(double i = 0.0; i <= stepCount ; i++) {

            double a1 = sqrt(left);
            double b1 = sqrt(right);
            res = res + (double) 1 / 2 * step * (a1 + b1);

            left = left + step;
            if(b < (right + step)){break;}
            right = right + step;
        }
        if(b < (right + step)){
            right = b;
            step = b - left;
            double a1 = sqrt(left);
            double b1 = sqrt(right);
            res = res + (double) 1 / 2 * step * (a1 + b1);
        }
        System.out.printf("%s \n", Thread.currentThread().getName());
        result.sum(res);

    }
}
