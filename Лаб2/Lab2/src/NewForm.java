import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class NewForm {
    public LinkedList<RecIntegral> TableList = new LinkedList<>();
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton CalcButton;
    private JButton AddButton;
    private JButton DelButton;
    private JTable table1;
    private JScrollPane scrollPane1;
    private JButton clearTableButton;
    private JButton addTableButton;
    DefaultTableModel model = (DefaultTableModel) table1.getModel();
    //String[] columnNames = {"Шаг", "Верхний", "Нижний", "Результат"};
    //String[][] data = { };
    public NewForm() {
        CalcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = 0; //down
                    double b = 0; //upp
                    double step = 0; //step
                    double res = 0;
                    for (int row = 0; row < table1.getRowCount(); row++) {
                        if (table1.getValueAt(row, 0) != "" || table1.getValueAt(row, 1) != "" || table1.getValueAt(row, 2) != "") {
                            step = Double.parseDouble(table1.getValueAt(row, 0).toString());
                            b = Double.parseDouble(table1.getValueAt(row, 1).toString());
                            a = Double.parseDouble(table1.getValueAt(row, 2).toString());
                            res = Main.Integral(a, b, step);
                            table1.setValueAt(res, row, 3);
                            //TableList.equals(new Object[]{String.valueOf(step), String.valueOf(b), String.valueOf(a), String.valueOf(res)});
                            RecIntegral temp = TableList.get(row);
                            temp.res = String.valueOf(res);
                            TableList.set(row, temp);


                            //for(RecIntegral iter: TableList) {
                                //iter.getComp(iter.step, iter.b, iter.a, String.valueOf(res));
                            //}
                        }
                    }
                } catch (Exception ex){ System.out.printf("Ошибка! %s", ex);}
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
                RecIntegral obj = new RecIntegral(textField1.getText(), textField2.getText(), textField3.getText(), "");
                TableList.add(obj);
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
                    TableList.remove(row);
                    //}
                } catch (Exception ex){}
            }
        });
        clearTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TableList.clear();
                model.getDataVector().removeAllElements();
                model.fireTableDataChanged();
            }
        });
        addTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                //model.removeRow(model.getRowCount()-1);
                //model.rowsRemoved(new DefaultTableModel(data,
                        //columnNames));
                //System.out.println(TableList);
                for(RecIntegral step: TableList){
                    //RecIntegral dt = new RecIntegral(step);
                    //RecIntegral Obj = new RecIntegral(step);
                    model.addRow(new Object[]{step.step,step.b,step.a,step.res});
                    //RecIntegral A = step.getStep();
                    //String value = new Object[]{step}.toString();
                    //model.addRow(new Object[]{value});
                    //model.addRow((Vector<?>) step);
                    //model.addRow(step.getStep(), step.getB(), step.getA(), step.get());
                    //step.getStep();
                }
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
        //scrollPane1.max
        scrollPane1.setPreferredSize(new Dimension(0, 150));

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
