package GUI;


import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

class AjoutOeuvrePanel extends JPanel {

    AjoutOeuvrePanel() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://127.0.0.1:5432/projet_mediatheque";
            String user = "postgres";
            String passwd = "root";

            conn = getConnection(url, user, passwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setLayout(new GridBagLayout());

        GridLayout mainLayout = new GridLayout();

        JTextField titre = new JTextField();
        titre.setPreferredSize(new Dimension(200, 30));
        this.add(titre);

        String[] listCategorie = {"Album", "Jeu", "Film", "Livre"};
        JComboBox<String> categorie = new JComboBox<>(listCategorie);
        categorie.setPreferredSize(new Dimension(100, 30));
        this.add(categorie);

        JButton origin = new JButton("Origin+");
        origin.setPreferredSize(new Dimension(100, 30));
        this.add(origin);

        try {
            Statement state = conn.createStatement();
            ResultSet recordedOrigins = state.executeQuery("select * from origin");
            if (recordedOrigins.next()) {
                JComboBox<String> comboOrigins = new JComboBox<>();
                do {
                    comboOrigins.addItem(recordedOrigins.getString("name_o"));
                } while (recordedOrigins.next());
                this.add(comboOrigins);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        JButton support = new JButton("Support+");
        support.setPreferredSize(new Dimension(100, 30));
        this.add(support);

        try {
            Statement state = conn.createStatement();
            ResultSet recordedSupports = state.executeQuery("select * from support");
            if (recordedSupports.next()) {
                JComboBox<String> comboSupports = new JComboBox<>();
                do {
                    comboSupports.addItem(recordedSupports.getString("name_s"));
                } while (recordedSupports.next());
                this.add(comboSupports);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        JButton version = new JButton("Version+");
        version.setPreferredSize(new Dimension(100, 30));
        this.add(version);

        try {
            Statement state = conn.createStatement();
            ResultSet recordedVersions = state.executeQuery("select * from version");
            if (recordedVersions.next()) {
                JComboBox<String> comboVersions = new JComboBox<>();
                do {
                    comboVersions.addItem(recordedVersions.getString("version"));
                } while (recordedVersions.next());
                this.add(comboVersions);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        JButton genre = new JButton("Genre+");
        genre.setPreferredSize(new Dimension(100, 30));
        this.add(genre);

        try {
            Statement state = conn.createStatement();
            ResultSet recordedgenres = state.executeQuery("select * from genre");
            if (recordedgenres.next()) {
                JComboBox<String> comboGenres = new JComboBox<>();
                do {
                    comboGenres.addItem(recordedgenres.getString("genre"));
                } while (recordedgenres.next());
                this.add(comboGenres);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

/*
coder sélection des morceaux
 */
        JButton morceaux = new JButton("Morceaux");
        this.add(morceaux);

/*
coder sélection des personalities
 */
        JButton personalities = new JButton("Auteurs");
        this.add(personalities);

    }
}
