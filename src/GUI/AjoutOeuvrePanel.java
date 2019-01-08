package GUI;


import database.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class AjoutOeuvrePanel extends JPanel {

    private Connection conn = Master.getConn();

    private JTextField titre;
    private JComboBox<Categorie> comboCategorie = new JComboBox<>();
    private JButton origin;
    private JComboBox<Origine> comboOrigins = new JComboBox<>();
    private JButton support;
    private JComboBox<Support> comboSupports = new JComboBox<>();
    private JButton version;
    private JComboBox<Version> comboVersions = new JComboBox<>();
    private JPanel morceauxPanel;
    private JPanel consolePanel;
    private JComboBox<Console> comboConsoles = new JComboBox<>();
    private JPanel finishedPanel;
    private JLabel finishedLabel;
    private JCheckBox finished;


    AjoutOeuvrePanel() {

        GridLayout mainLayout = new GridLayout(11, 1);
        mainLayout.setVgap(7);
        this.setLayout(mainLayout);

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

        for (Categorie cat : Master.readCategorie()) {
            comboCategorie.addItem(cat);
        }


        categorieLabel.setLabelFor(comboCategorie);
        categoriePanel.add(comboCategorie);
        this.add(categoriePanel);

        //===== origine =====
        JPanel originPanel = new JPanel(new GridLayout(1, 3));

        JLabel originLabel = new JLabel("Origine : ");

        origin = new JButton("Origin+");
        origin.setPreferredSize(new Dimension(100, 30));
        origin.addActionListener(e -> {
            String newNameOrigin = ConfirmNewValue.showDialog();
            if (!newNameOrigin.equals("")) {
                Origine nvOrigine = new Origine(newNameOrigin);
                nvOrigine.create();
                comboOrigins.addItem(nvOrigine);
            }
        });
        List<Origine> reqOri = Master.readOrigin();
        for (Origine ori : reqOri) {
            comboOrigins.addItem(ori);
        }

        originLabel.setLabelFor(origin);
        originPanel.add(originLabel);

        if (!reqOri.equals(new ArrayList())) {
            originPanel.add(comboOrigins);
            System.out.println(reqOri);
        }
        originPanel.add(origin);
        this.add(originPanel);

        //===== support =====
        JPanel supportPanel = new JPanel(new GridLayout(1, 3));

        JLabel supportLabel = new JLabel("Support : ");

        support = new JButton("Support+");
        support.setPreferredSize(new Dimension(100, 30));
        support.addActionListener(e -> {
            String newNameSupport = ConfirmNewValue.showDialog();
            if (!newNameSupport.equals("")) {
                Support nvSupport = new Support(newNameSupport);
                nvSupport.create();
                comboSupports.addItem(nvSupport);
            }
        });

        supportLabel.setLabelFor(support);
        supportPanel.add(supportLabel);

        List<Support> reqSupp = Master.readSupport();
        for (Support supp : reqSupp) {
            comboSupports.addItem(supp);
        }
        if (!reqSupp.equals(new ArrayList<>())) {
            supportPanel.add(comboSupports);
        }
        supportPanel.add(support);
        this.add(supportPanel);

        //===== version =====
        JPanel versionPanel = new JPanel(new GridLayout(1, 3));

        JLabel versionLabel = new JLabel("Version : ");

        version = new JButton("Version+");
        version.setPreferredSize(new Dimension(100, 30));
        versionLabel.setLabelFor(version);
        versionPanel.add(versionLabel);

        List<Version> reqVer = Master.readVersion();
        for (Version vers : reqVer) {
            comboVersions.addItem(vers);
        }

        if (comboVersions.getItemCount() == 0) {
            versionPanel.setBackground(Color.red);
        }

        version.addActionListener(e -> {
            String newNameVersion = ConfirmNewValue.showDialog();
            if (!newNameVersion.equals("")) {
                Version nvVersion = new Version(newNameVersion);
                nvVersion.create();
                comboVersions.addItem(nvVersion);
                versionPanel.setBackground(null);
            }
        });
        versionPanel.add(comboVersions);
        versionPanel.add(version);
        this.add(versionPanel);

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

        morceauxPanel = new JPanel(new GridLayout(1, 2));

        JLabel morceauxLabel = new JLabel("Morceaux : ");

        //JButton morceaux = new JButton("Morceaux");
        //morceaux.addActionListener(e -> JOptionPane.showMessageDialog(this, "BOITE DE DIALOGUE AJOUT MULTIPLE DE MORCEAUX, CRéATION DE MORCEAUX", "BOITE DE DIALOGUE", JOptionPane.INFORMATION_MESSAGE));
        JTextField morceaux = new JTextField();
        morceauxLabel.setLabelFor(morceaux);
        morceauxPanel.add(morceauxLabel);
        morceauxPanel.add(morceaux);
        morceauxPanel.setVisible(false);
        this.add(morceauxPanel);

/*
coder sélection des personalities
 */

        JPanel personalitiesPanel = new JPanel(new GridLayout(1, 2));

        JLabel personalitiesLabel = new JLabel("Auteurs : ");

        JButton personalities = new JButton("Auteurs");
        personalities.addActionListener(e -> {
            DialogPersonalities sd = new DialogPersonalities(null, "Test test");
            sd.setVisible(true);
            System.out.println("Value: " + sd.getValue1());
        });
        personalitiesLabel.setLabelFor(personalities);
        personalitiesPanel.add(personalitiesLabel);
        personalitiesPanel.add(personalities);
        this.add(personalitiesPanel);

        //===== console =====
        consolePanel = new JPanel(new GridLayout(1, 3));

        JLabel consoleLabel = new JLabel("Console : ");

        JButton console = new JButton("Console+");
        console.setPreferredSize(new Dimension(100, 30));
        console.addActionListener(e -> {
            String newNameConsole = JOptionPane.showInputDialog(null, "Veuillez entrer une nouvelle console", "Nouvelle console", JOptionPane.QUESTION_MESSAGE);
            Console nvConsole = new Console(newNameConsole);
            nvConsole.create();
            comboConsoles.addItem(nvConsole);
        });
        consoleLabel.setLabelFor(console);
        consolePanel.add(consoleLabel);
        consolePanel.add(console);

        try {
            Statement state = conn.createStatement();
            ResultSet recordedConsoles = state.executeQuery("select * from console");
            if (recordedConsoles.next()) {
                comboConsoles = new JComboBox<>();
                do {
                    comboConsoles.addItem(new Console(recordedConsoles.getInt("id_c"), recordedConsoles.getString("name_c")));
                } while (recordedConsoles.next());
                consolePanel.add(comboConsoles);
            }
            this.add(consolePanel);
            consolePanel.setVisible(false);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        //===== finished =====

        finishedPanel = new JPanel(new GridLayout(1, 2));
        finishedLabel = new JLabel("Terminé : ");
        finished = new JCheckBox();
        finishedLabel.setLabelFor(finished);
        finishedPanel.add(finishedLabel);
        finishedPanel.add(finished);
        this.add(finishedPanel);


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

            if (comboCategorie.getSelectedItem().toString().equals("Album")) {
                morceauxPanel.setVisible(true);
            } else {
                morceauxPanel.setVisible(false);
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
