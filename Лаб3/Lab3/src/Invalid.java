import javax.swing.*;
public class Invalid extends Exception{
    public Invalid(String message) {
        //super(message);
        JOptionPane.showMessageDialog(null, message, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }
}
