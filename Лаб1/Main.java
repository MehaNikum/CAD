import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Math.*;
public class Main {
    public static void main(String[] args) {
        double a = 0;
        double b = 0;
        double step = 0;
        //Object[] columnsHeader = new String[] {"A", "B",
                //"Step", "Result"};
        //System.out.print(calculation(a,b,step));

        JFrame frame = new JFrame("Integral Hujnya");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        frame.add(panel);
        JButton buttonSet = new JButton("Set");
        JButton buttonClear = new JButton("Clear");
        JButton buttonCalc = new JButton("Calculation");
        panel.add(buttonSet);
        panel.add(buttonClear);
        panel.add(buttonCalc);
        JTable table = new JTable(3, 4);
        panel.add(table);

        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.clearSelection();
            }
        });
        buttonCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JTextField A = new JTextField("",6);
        JTextField B = new JTextField("",6);
        JTextField Step = new JTextField("",6);
        panel.add(A);
        panel.add(B);
        panel.add(Step);


        frame.setVisible(true);

/*
        JPanel panelText = new JPanel();
        JPanel panelBut = new JPanel();


        //butSet.setSize(300,300);
        JButton butCalc = new JButton();
        JButton butClear = new JButton();

        JTextField BoxA = new JTextField("",7);
        JTextField BoxB = new JTextField("",7);
        JTextField BoxStep = new JTextField("",7);


        panelText.add(BoxA);
        panelText.add(BoxB);
        panelText.add(BoxStep);
*/


        //panel1.setSize(200,100);
        //panel1.setBackground(Color.BLUE);
        //panel2.setBackground(Color.GRAY);
        //JButton button = new JButton("Press");
        //BoxA.setSize(100, 100);
        //BoxA.setBounds(50,50,50,50);
        //BoxB.setSize(100, 100);
        //BoxB.setBounds(100,50,50,50);
        //BoxStep.setSize(150, 100);
        //BoxStep.setBounds(150,50,50,50);

        //panel1.add(table);
        //panelBut.add(butSet);
        //panelBut.add(butCalc);
        //panelBut.add(butClear);

        //frame.add(BoxA);
        //frame.add(BoxB);
        //frame.add(BoxStep);
        // getContentPane() - клиентская область окна


        //frame.add(panelBut);
        //frame.add(panelText);


        ////////////////////////////////////

        //JButton start = new JButton("Старт");
        //JButton stop = new JButton("Стоп");
        //buttonsPanel.add(start);
        //buttonsPanel.add(stop);

        // размещаем панель на Frame (верхняя часть)
        //frame.getContentPane().add(BorderLayout.NORTH, panel1);
        //frame.getContentPane().add(BorderLayout.SOUTH, BoxA);
        //frame.getContentPane().add(BorderLayout.NORTH, BoxA);




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