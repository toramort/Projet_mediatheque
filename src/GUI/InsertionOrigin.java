package GUI;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

class InsertionOrigin extends JOptionPane {
    InsertionOrigin() {
        String nvOrigin = showInputDialog(null, "Veuillez entrer un nouveau nom d'origine", "Nouvelle origine", JOptionPane.QUESTION_MESSAGE);
        Connection conn = ConnectionDB.getConn();
        try {
            String query = "INSERT INTO origin(name_o) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, nvOrigin);
            statement.execute();
            showMessageDialog(this, "Vous avez bien ajouté " + nvOrigin + " comme nouvelle origine", "Nouvelle origine", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
