import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class NewForm {
    double a = 0; //down
    double b = 0; //upp
    double step = 0; //step

    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton CalcButton;
    private JButton AddButton;
    private JButton DelButton;
    private JTable table1;
    private JScrollPane scrollPane1;
    DefaultTableModel model = (DefaultTableModel) table1.getModel();
    
    public NewForm() {
        CalcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int row = 0; row < table1.getRowCount(); row++){
                    if(table1.getValueAt(row,0) == "" || table1.getValueAt(row,1) == "" || table1.getValueAt(row,2) == ""){ }
                    else {
                        step = Double.parseDouble(table1.getValueAt(row, 0).toString());
                        b = Double.parseDouble(table1.getValueAt(row, 1).toString());
                        a = Double.parseDouble(table1.getValueAt(row, 2).toString());
                        table1.setValueAt(Main.Integral(a, b, step), row, 3);
                    }
                }
            }
        });
        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String[][] data = {
//                        {"Шаг", "Верхний", "Нижний", "Результат"},
//                        {"","","",""},
//                        {"","","",""}
//                };
                //table1.setModel(new DefaultTableModel().addRow(new Object[]{"","","",""}));
                //table1.add
                //DefaultTableModel model = (DefaultTableModel) table1.getModel();
                model.addRow(new Object[]{textField1.getText(), textField2.getText(), textField3.getText()});

                //table1.setValueAt(table1.getValueAt(1,0),2,0);
                //table1.setValueAt(table1.getValueAt(1,1),2,1);
                //table1.setValueAt(table1.getValueAt(1,2),2,2);
                //table1.setValueAt(table1.getValueAt(1,3),2,3);

                //table1.setValueAt(textField1.getText(),1,0);
                //table1.setValueAt(textField2.getText(),1,1);
                //table1.setValueAt(textField3.getText(),1,2);
                //table1.setValueAt("",1,3);
            }
        });
        DelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int row = table1.getSelectedRow();
                //final int column = table1.getSelectedColumn();
                //for(int i = 0; i < 4; i++) {
                    //table1.setValueAt("", row, i);
                try {
                    model.removeRow(row);
                    //}
                } catch (Exception er){}
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Integrator √x");
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new NewForm().panel1);
        //frame.setContentPane(new NewForm().scrollPane1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    private void createUIComponents() {

        scrollPane1 = new JScrollPane(table1);


        //table1.add
        String[] columnNames = {"Шаг", "Верхний", "Нижний", "Результат"};
        String[][] data = { };
        table1 = new JTable(data, columnNames);
        //table1.setBounds(30, 40, 200, 300);
        table1.setModel(new DefaultTableModel(data,
                                columnNames
        ) {public boolean isCellEditable(int row, int column){return (column == 0 || column == 1 || column == 2);}}
        );
    }

}
