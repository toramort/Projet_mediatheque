package GUI;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

class InsertionSupport extends JOptionPane {
    InsertionSupport() {
        String nvSupport = showInputDialog(null, "Veuillez entrer un nouveau nom de support", "Nouvelle origine", JOptionPane.QUESTION_MESSAGE);
        Connection conn = ConnectionDB.getConn();
        try {
            String query = "INSERT INTO support(name_s) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, nvSupport);
            statement.execute();
            showMessageDialog(this, "Vous avez bien ajouté " + nvSupport + " comme nouveau support", "Nouveau support", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
