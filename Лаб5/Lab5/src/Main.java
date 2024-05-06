import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.*;
class Res {
    public double result = 0.0;
    public synchronized void sum(double input_res){ result += input_res; }
    public double get(){ return result; }
}
public class Main {

    public static double Integral(double a, double b, double step) throws InterruptedException {
        Res result = new Res();

        double h = b - a; //интервал
        h = h / 6; //interval segmenta
        b = a + h;
        //double stepCount = 0;
        //if((h/step) % 1 == 0){ stepCount = h / step; }
        //else{ stepCount = floor(h / step); }  //2  //2.5
        List<Thread> normalList = new ArrayList<Thread>();
        List<Thread> threads = Collections.synchronizedList(normalList);
        for(int i = 1; i<7; i++){
            threads.add(new Thread(new MyThread(a, b, step, h, result), String.valueOf(i)));
            a += h;
            b += h;
        }
        for(Thread temp: threads){
            temp.start();
            temp.join();
        }

//        for (int i : mass) {
//            myThread = new Thread(new MyThread(a, b, step, h, result), String.valueOf(i));
//            myThread.start();
//        }
//        double left = a;
//        double right = a + step;
//        double res = 0.0;

//        for(double i = 0.0; i <= stepCount ; i++) {

//            double a1 = sqrt(left);
//            double b1 = sqrt(right);
//            res = res + (double) 1 / 2 * step * (a1 + b1);

//            left = left + step;
//            if(b < (right + step)){break;}
//            right = right + step;
//        }
//        if(b < (right + step)){
//            right = b;
//            step = b - left;
//            double a1 = sqrt(left);
//            double b1 = sqrt(right);
//            res = res + (double) 1 / 2 * step * (a1 + b1);
//        }
        //return res;
        return result.get();
    }
}