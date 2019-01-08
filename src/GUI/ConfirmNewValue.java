package GUI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ConfirmNewValue extends JOptionPane {

    ConfirmNewValue() {
    }

    public static String showDialogSimpleTextField() {
        JTextField valeur = new JTextField(20);
        JPanel panel = new JPanel();
        panel.add(new JLabel("Valeur : "));
        panel.add(valeur);

        int result = JOptionPane.showConfirmDialog(null, panel,
            "Entrez une nouvelle valeur", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            return valeur.getText();
        } else {
            return "";
        }
    }

    public static List<String> showDialogTripleField() {
        JTextField valeur = new JTextField(20);
        JTextField valeur1 = new JTextField(20);
        JTextField valeur2 = new JTextField(20);
        JPanel panel = new JPanel();
        panel.add(new JLabel("FirstName : "));
        panel.add(valeur);
        panel.add(new JLabel("LastName : "));
        panel.add(valeur1);
        panel.add(new JLabel("Surname : "));
        panel.add(valeur2);

        int result = JOptionPane.showConfirmDialog(null, panel,
            "Entrez des nouvelle valeur", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            List<String> temp = new ArrayList<>();
            temp.add(valeur.getText());
            temp.add(valeur1.getText());
            temp.add(valeur2.getText());
            return temp;
        } else {
            return new ArrayList<>();
        }
    }

}
