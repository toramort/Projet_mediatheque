package GUI;

import javax.swing.*;

public class ConfirmNewValue extends JOptionPane {

    ConfirmNewValue() {
    }

    public static String showDialog() {
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

}
