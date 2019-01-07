package GUI;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

class InsertionConsole extends JOptionPane {
    InsertionConsole() {
        String nvConsole = showInputDialog(null, "Veuillez entrer une nouvelle console", "Nouvelle console", JOptionPane.QUESTION_MESSAGE);
        Connection conn = ConnectionDB.getConn();
        try {
            String query = "INSERT INTO console(name_c) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, nvConsole);
            statement.execute();
            showMessageDialog(this, "Vous avez bien ajouté " + nvConsole + " comme nouvelle console", "Nouvelle console", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
