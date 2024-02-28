
import javax.swing.*;
import java.awt.*;

import static java.lang.Math.*;
public class Program {
    public static void main(String[] args) {
        double a = 5;
        double b = 9;
        double step = 1.6;
        System.out.print(calculation(a,b,step));


        //JFrame frame = new JFrame("My First GUI");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(600, 300);
        //frame.setLocationRelativeTo(null);
        //JPanel panel = new JPanel();
        //JPanel buttonsPanel = new JPanel();
        //JButton button = new JButton("Press");


        //JTextField BoxA = new JTextField();
        //JTextField BoxB = new JTextField();
        //JTextField BoxStep = new JTextField();
        //JTable table = new JTable(3, 3);
        //frame.add(table);
        //panel.add(table);

        // getContentPane() - клиентская область окна
        //frame.getContentPane().add(button); // Добавляем кнопку на Frame

        //frame.setVisible(true); // Делаем окно видимым
        ////////////////////////////////////








        //JButton start = new JButton("Старт");
        //JButton stop = new JButton("Стоп");
        //buttonsPanel.add(start);
        //buttonsPanel.add(stop);


        // размещаем панель на Frame (верхняя часть)
        //frame.getContentPane().add(BorderLayout.SOUTH, panel);
    }
    public static double calculation(double a, double b, double step) {
        double h = b - a;
        double stepCount = 0;
        if(h/step == (int)h/step){ stepCount = h / step; }
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

    public static double integral(double a) { return (double) 2 / 3 * sqrt(pow(a,3)); }
    public static double square(double h, double a, double b){
        return (double) 1 / 2 * h * (a + b);
    }

}