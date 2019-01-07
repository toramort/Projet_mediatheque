package GUI;


import dataObjects.Categorie;
import dataObjects.Origine;
import dataObjects.Support;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

class AjoutOeuvrePanel extends JPanel {

    private Connection conn;

    private JTextField titre;
    private JComboBox<Categorie> comboCategorie;
    private JButton origin;
    private JComboBox<Origine> comboOrigins;
    private JButton support;
    private JComboBox<Support> comboSupports;
    private JButton version;
    private JComboBox<String> comboVersions;
    private JPanel consolePanel;


    AjoutOeuvrePanel() {

        conn = null;
        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://127.0.0.1:5432/projet_mediatheque";
            String user = "postgres";
            String passwd = "root";

            conn = getConnection(url, user, passwd);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Connection to database failed", "Error", JOptionPane.INFORMATION_MESSAGE);
        }

        this.setLayout(new GridLayout(10, 1));

        //===== titre =====
        JPanel titrePanel = new JPanel();
        titrePanel.setLayout(new GridLayout(1, 2));

        JLabel titreLabel = new JLabel("Titre : ");
        titrePanel.add(titreLabel);

        titre = new JTextField();
        titre.setPreferredSize(new Dimension(200, 30));
        titreLabel.setLabelFor(titre);
        titrePanel.add(titre);
        this.add(titrePanel);

        //==== catégorie =====
        JPanel categoriePanel = new JPanel(new GridLayout(1, 3));

        JLabel categorieLabel = new JLabel("Catégorie : ");
        categoriePanel.add(categorieLabel);

        try {
            Statement state = conn.createStatement();
            ResultSet recordedCategories = state.executeQuery("select * from categorie");
            if (recordedCategories.next()) {
                comboCategorie = new JComboBox<>();
                do {
                    comboCategorie.addItem(new Categorie(recordedCategories.getInt("id_c"), recordedCategories.getString("name_c")));
                } while (recordedCategories.next());
                comboCategorie.addActionListener(new categorieListener());
                categoriePanel.add(comboOrigins);
                this.add(categoriePanel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        categorieLabel.setLabelFor(comboCategorie);
        categoriePanel.add(comboCategorie);
        this.add(categoriePanel);

        //===== origine =====
        JPanel originPanel = new JPanel(new GridLayout(1, 3));

        JLabel originLabel = new JLabel("Origine : ");

        origin = new JButton("Origin+");
        origin.setPreferredSize(new Dimension(100, 30));
        originLabel.setLabelFor(origin);
        originPanel.add(originLabel);
        originPanel.add(origin);

        try {
            Statement state = conn.createStatement();
            ResultSet recordedOrigins = state.executeQuery("select * from origin");
            if (recordedOrigins.next()) {
                comboOrigins = new JComboBox<>();
                do {
                    comboOrigins.addItem(new Origine(recordedOrigins.getString("name_o"), recordedOrigins.getInt("id_o")));
                } while (recordedOrigins.next());
                originPanel.add(comboOrigins);
                this.add(originPanel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //===== support =====
        JPanel supportPanel = new JPanel(new GridLayout(1, 3));

        JLabel supportLabel = new JLabel("Support : ");

        support = new JButton("Support+");
        support.setPreferredSize(new Dimension(100, 30));
        supportLabel.setLabelFor(support);
        supportPanel.add(supportLabel);
        supportPanel.add(support);

        try {
            Statement state = conn.createStatement();
            ResultSet recordedSupports = state.executeQuery("select * from support");
            if (recordedSupports.next()) {
                comboSupports = new JComboBox<>();
                do {
                    comboSupports.addItem(recordedSupports.getString("name_s"));
                } while (recordedSupports.next());
                supportPanel.add(comboSupports);
                this.add(supportPanel);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        //===== version =====
        JPanel versionPanel = new JPanel(new GridLayout(1, 3));

        JLabel versionLabel = new JLabel("Version : ");

        version = new JButton("Version+");
        version.setPreferredSize(new Dimension(100, 30));
        versionLabel.setLabelFor(version);
        versionPanel.add(versionLabel);
        versionPanel.add(version);

        try {
            Statement state = conn.createStatement();
            ResultSet recordedVersions = state.executeQuery("select * from version");
            if (recordedVersions.next()) {
                comboVersions = new JComboBox<>();
                do {
                    comboVersions.addItem(recordedVersions.getString("version"));
                } while (recordedVersions.next());
                versionPanel.add(comboVersions);
                this.add(versionPanel);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        //===== genre =====
        JPanel genrePanel = new JPanel(new GridLayout(1, 3));

        JLabel genreLabel = new JLabel("Genre : ");

        JButton genre = new JButton("Genre+");
        genre.setPreferredSize(new Dimension(100, 30));
        genreLabel.setLabelFor(genre);
        genrePanel.add(genreLabel);
        genrePanel.add(genre);

        try {
            Statement state = conn.createStatement();
            ResultSet recordedgenres = state.executeQuery("select * from genre");
            if (recordedgenres.next()) {
                JComboBox<String> comboGenres = new JComboBox<>();
                do {
                    comboGenres.addItem(recordedgenres.getString("genre"));
                } while (recordedgenres.next());
                genrePanel.add(comboGenres);
                this.add(genrePanel);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

/*
coder sélection des morceaux
 */

        JPanel morceauxPanel = new JPanel(new GridLayout(1, 2));

        JLabel morceauxLabel = new JLabel("Morceaux : ");

        //JButton morceaux = new JButton("Morceaux");
        //morceaux.addActionListener(e -> JOptionPane.showMessageDialog(this, "BOITE DE DIALOGUE AJOUT MULTIPLE DE MORCEAUX, CRéATION DE MORCEAUX", "BOITE DE DIALOGUE", JOptionPane.INFORMATION_MESSAGE));
        JTextField morceaux = new JTextField();
        morceauxLabel.setLabelFor(morceaux);
        morceauxPanel.add(morceauxLabel);
        morceauxPanel.add(morceaux);
        this.add(morceauxPanel);

/*
coder sélection des personalities
 */

        JPanel personalitiesPanel = new JPanel(new GridLayout(1, 2));

        JLabel personalitiesLabel = new JLabel("Auteurs : ");

        //JButton personalities = new JButton("Auteurs");
        //personalities.addActionListener(e -> JOptionPane.showMessageDialog(null, "BOITE DE DIALOGUE AJOUT MULTIPLE DE PERSONALITIES, CRéATION DE PERSONNALITIES", "BOITE DE DIALOGUE", JOptionPane.INFORMATION_MESSAGE));
        JTextField personalities = new JTextField();
        personalitiesLabel.setLabelFor(personalities);
        personalitiesPanel.add(personalitiesLabel);
        personalitiesPanel.add(personalities);
        this.add(personalitiesPanel);

        //===== console =====
        consolePanel = new JPanel(new GridLayout(1, 3));

        JLabel consoleLabel = new JLabel("Console : ");

        JButton console = new JButton("Console+");
        console.setPreferredSize(new Dimension(100, 30));
        consoleLabel.setLabelFor(console);
        consolePanel.add(consoleLabel);
        consolePanel.add(console);

        try {
            Statement state = conn.createStatement();
            ResultSet recordedConsoles = state.executeQuery("select * from console");
            if (recordedConsoles.next()) {
                JComboBox<String> comboConsoles = new JComboBox<>();
                do {
                    comboConsoles.addItem(recordedConsoles.getString("name_c"));
                } while (recordedConsoles.next());
                consolePanel.add(comboConsoles);
                consolePanel.setBackground(Color.red);

                System.out.println("iuzbrg");

            }
            this.add(consolePanel);
            consolePanel.setVisible(false);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        JButton boutonEnvoyer = new JButton("Envoyer");
        this.add(boutonEnvoyer);

    }

    class categorieListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (comboCategorie.getSelectedIndex() == 3) {
                consolePanel.setVisible(true);
            } else {
                consolePanel.setVisible(false);
            }
        }
    }
/*
    class titreListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            String titlestr = titre.getText();
            String
            String query = "INSERT INTO oeuvre(title, date_ajout, date_oeuvre, finished, id_p, id_o, id_c, id_s) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, titre_film.getText());

            statement.execute();
        }
    }
    */
}
