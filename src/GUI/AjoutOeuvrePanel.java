package GUI;


import database.*;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class AjoutOeuvrePanel extends JPanel {
    private JTextField titre;
    private JComboBox<Categorie> comboCategorie = new JComboBox<>();
    private JComboBox<Origine> comboOrigins = new JComboBox<>();
    private JComboBox<Support> comboSupports = new JComboBox<>();
    private JComboBox<Version> comboVersions = new JComboBox<>();
    private JComboBox<Genre> comboGenre = new JComboBox<>();
    private JPanel morceauxPanel;
    private JPanel personalitiesPanel;
    private JComboBox<Personality> comboPersonalities = new JComboBox<>();
    private JFormattedTextField dateField;
    private JPanel consolePanel;
    private JComboBox<Console> comboConsoles = new JComboBox<>();
    private JCheckBox finished;


    AjoutOeuvrePanel() {

        GridBagLayout mainLayout = new GridBagLayout();


        JPanel container = new JPanel();

        GridLayout containerLayout = new GridLayout(11, 1);
        containerLayout.setVgap(20);
        container.setLayout(containerLayout);

        //===== titre =====
        JPanel titrePanel = new JPanel(new GridLayout(1, 2, 75, 0));

        JLabel titreLabel = new JLabel("Titre : ");
        titrePanel.add(titreLabel);

        titre = new JTextField();
        titre.setPreferredSize(new Dimension(200, 30));
        titreLabel.setLabelFor(titre);
        titrePanel.add(titre);
        container.add(titrePanel);

        //==== catégorie =====
        JPanel categoriePanel = new JPanel();

        for (Categorie cat : Categorie.read()) {
            comboCategorie.addItem(cat);
        }
        comboCategorie.addActionListener(e -> {
            if (comboCategorie.getSelectedItem().toString().equals("Jeu-vidéo")) {
                container.add(consolePanel);
            } else {
                container.remove(consolePanel);
            }

            if (comboCategorie.getSelectedItem().toString().equals("Album")) {
                container.add(morceauxPanel);
            } else {
                container.remove(morceauxPanel);
            }
            container.revalidate();
            container.repaint();
        });

        categoriePanel.setBorder(BorderFactory.createTitledBorder("Categorie"));
        categoriePanel.add(comboCategorie);
        container.add(categoriePanel);

        //===== origine =====
        JPanel originPanel = new JPanel(new GridLayout(1, 3, 75, 0));
        JLabel originLabel = new JLabel("Origine : ");

        JButton origin = new JButton("Origine+");

        origin.addActionListener(e -> {
            String newNameOrigin = ConfirmNewValue.showDialogSimpleTextField();
            if (!newNameOrigin.equals("")) {
                Origine nvOrigine = new Origine(newNameOrigin);
                nvOrigine.create();
                comboOrigins.addItem(nvOrigine);
                originPanel.setBackground(null);
            }
        });

        List<Origine> reqOri = Origine.read();
        for (Origine ori : reqOri) {
            comboOrigins.addItem(ori);
        }

        originLabel.setLabelFor(origin);
        originPanel.add(originLabel);

        if (comboOrigins.getItemCount() == 0) {
            originPanel.setBackground(Color.red);
        }
        originPanel.add(comboOrigins);
        originPanel.add(origin);
        container.add(originPanel);

        //===== support =====
        JPanel supportPanel = new JPanel(new GridLayout(1, 3, 75, 0));

        JLabel supportLabel = new JLabel("Support : ");

        JButton support = new JButton("Support+");
        support.setPreferredSize(new Dimension(100, 30));
        support.addActionListener(e -> {
            String newNameSupport = ConfirmNewValue.showDialogSimpleTextField();
            if (!newNameSupport.equals("")) {
                Support nvSupport = new Support(newNameSupport);
                nvSupport.create();
                comboSupports.addItem(nvSupport);
                supportPanel.setBackground(null);
            }
        });

        supportLabel.setLabelFor(support);
        supportPanel.add(supportLabel);

        List<Support> reqSupp = Support.read();
        for (Support supp : reqSupp) {
            comboSupports.addItem(supp);
        }
        if (comboSupports.getItemCount() == 0) {
            supportPanel.setBackground(Color.red);
        }
        supportPanel.add(comboSupports);
        supportPanel.add(support);
        container.add(supportPanel);

        //===== version =====
        JPanel versionPanel = new JPanel(new GridLayout(1, 3, 75, 0));

        JLabel versionLabel = new JLabel("Version : ");

        JButton version = new JButton("Version+");
        version.setPreferredSize(new Dimension(100, 30));
        versionLabel.setLabelFor(version);
        versionPanel.add(versionLabel);

        List<Version> reqVer = Version.read();
        for (Version vers : reqVer) {
            comboVersions.addItem(vers);
        }

        if (comboVersions.getItemCount() == 0) {
            versionPanel.setBackground(Color.red);
        }

        version.addActionListener(e -> {
            String newNameVersion = ConfirmNewValue.showDialogSimpleTextField();
            if (!newNameVersion.equals("")) {
                Version nvVersion = new Version(newNameVersion);
                nvVersion.create();
                comboVersions.addItem(nvVersion);
                versionPanel.setBackground(null);
            }
        });
        versionPanel.add(comboVersions);
        versionPanel.add(version);
        container.add(versionPanel);

        //===== genre =====
        JPanel genrePanel = new JPanel(new GridLayout(1, 3, 75, 0));

        JLabel genreLabel = new JLabel("Genre : ");

        JButton genre = new JButton("Genre+");

        List<Genre> reqGenre = Genre.read();
        for (Genre pers : reqGenre) {
            comboGenre.addItem(pers);
        }

        if (comboGenre.getItemCount() == 0) {
            genrePanel.setBackground(Color.red);
        }

        genre.addActionListener(e -> {
            String newNameGenre = ConfirmNewValue.showDialogSimpleTextField();
            if (!newNameGenre.equals("")) {
                Genre nvGenre = new Genre(newNameGenre);
                nvGenre.create();
                comboGenre.addItem(nvGenre);
                genrePanel.setBackground(null);
            }
        });
        genreLabel.setLabelFor(genre);
        genrePanel.add(genreLabel);
        genrePanel.add(comboGenre);
        genrePanel.add(genre);
        container.add(genrePanel);



/*
coder sélection des morceaux
 */

        morceauxPanel = new JPanel(new GridLayout(1, 3, 75, 0));

        JLabel morceauxLabel = new JLabel("Morceaux : ");

        //JButton morceaux = new JButton("Morceaux");
        //morceaux.addActionListener(e -> JOptionPane.showMessageDialog(container, "BOITE DE DIALOGUE AJOUT MULTIPLE DE MORCEAUX, CRéATION DE MORCEAUX", "BOITE DE DIALOGUE", JOptionPane.INFORMATION_MESSAGE));
        JTextField morceaux = new JTextField();
        morceauxLabel.setLabelFor(morceaux);
        morceauxPanel.add(morceauxLabel);
        morceauxPanel.add(morceaux);


        // ===== personalitites =====

        personalitiesPanel = new JPanel(new GridLayout(1, 3, 75, 0));

        JLabel personalitiesLabel = new JLabel("Auteurs : ");

        JButton personalities = new JButton("Auteurs");

        List<Personality> reqPers = Personality.read();
        for (Personality pers : reqPers) {
            comboPersonalities.addItem(pers);
        }

        if (comboPersonalities.getItemCount() == 0) {
            personalitiesPanel.setBackground(Color.red);
        }

        personalities.addActionListener(e -> {
            List newParamPersonality = ConfirmNewValue.showDialogTripleField();
            if (!newParamPersonality.equals(new ArrayList<>())) {
                Personality nvPersonality = new Personality((String) newParamPersonality.get(0), (String) newParamPersonality.get(1), (String) newParamPersonality.get(2), (Job) newParamPersonality.get(3));
                nvPersonality.create();
                nvPersonality.createAssocJob();
                comboPersonalities.addItem(nvPersonality);
                personalitiesPanel.setBackground(null);
            }
        });
        personalitiesLabel.setLabelFor(personalities);
        personalitiesPanel.add(personalitiesLabel);
        personalitiesPanel.add(comboPersonalities);
        personalitiesPanel.add(personalities);
        container.add(personalitiesPanel);

        //===== date =====
        JPanel datePanel = new JPanel(new GridLayout(1, 2, 75, 0));
        JLabel dateLabel = new JLabel("Date : ");
        try {
            MaskFormatter dateMask = new MaskFormatter("####-##-##");
            dateField = new JFormattedTextField(dateMask);
        } catch (ParseException e) {
            System.out.println(e.getErrorOffset());
        }
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        dateField.setLocation(5, 5);
        dateField.setSize(150, 20);
        dateField.setFont(font1);
        dateField.setHorizontalAlignment(JTextField.CENTER);

        datePanel.add(dateLabel);
        datePanel.add(dateField);
        container.add(datePanel);


        //===== console =====
        consolePanel = new JPanel(new GridLayout(1, 3, 75, 0));

        JLabel consoleLabel = new JLabel("Console : ");

        JButton console = new JButton("Console+");
        List<Console> reqCons = Console.read();
        for (Console cons : reqCons) {
            comboConsoles.addItem(cons);
        }

        if (comboConsoles.getItemCount() == 0) {
            consolePanel.setBackground(Color.red);
        }

        console.addActionListener(e -> {
            String newNameConsole = ConfirmNewValue.showDialogSimpleTextField();
            if (!newNameConsole.equals("")) {
                Console nvConsole = new Console(newNameConsole);
                nvConsole.create();
                comboConsoles.addItem(nvConsole);
                comboConsoles.setBackground(null);
            }
        });
        consolePanel.add(consoleLabel);
        consolePanel.add(comboConsoles);
        consolePanel.add(console);


        //===== finished =====

        JPanel finishedPanel = new JPanel(new GridLayout(1, 2, 75, 0));
        JLabel finishedLabel = new JLabel("Terminé : ");
        finished = new JCheckBox();
        finishedLabel.setLabelFor(finished);
        finishedPanel.add(finishedLabel);
        finishedPanel.add(finished);
        container.add(finishedPanel);


        JButton boutonEnvoyer = new JButton("Envoyer");
        boutonEnvoyer.addActionListener(new FinalListener());
        container.add(boutonEnvoyer);
        this.add(container);

    }


    class FinalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            Categorie finalCat = (Categorie) comboCategorie.getSelectedItem();
            String finalTitre = titre.getText();
            Origine finalOrigin = (Origine) comboOrigins.getSelectedItem();
            Support finalSupport = (Support) comboSupports.getSelectedItem();
            Version finalversion = (Version) comboVersions.getSelectedItem();
            Genre finalgenre = (Genre) comboGenre.getSelectedItem();
            Personality finalPersonality = (Personality) comboPersonalities.getSelectedItem();
            LocalDate finalDate = null;
            Console finalConsole = null;
            if (AjoutOeuvrePanel.this.consolePanel.isVisible()) {
                finalConsole = (Console) comboConsoles.getSelectedItem();
            }
            try {
                finalDate = stringToLocaldate(dateField.getText());
            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(null, "Remplissez bien la date !",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
            boolean finalFinished = finished.isSelected();
            finalCat.getId_c();
            System.out.println(finished.isSelected());
            System.out.println(finalDate);
            switch (finalCat.getId_c()) {
                case 1: {
                    Film nvOeuvre = new Film(finalTitre, finalDate, finalFinished, finalPersonality, finalgenre, finalOrigin, finalversion, finalSupport, finalCat);
                    nvOeuvre.create();
                    System.out.println(finalCat.getName_c());
                    break;
                }
                case 2: {
                    Album nvAlbum = new Album(finalTitre, finalDate, finalFinished, finalPersonality, finalgenre, finalOrigin, finalSupport, finalCat);
                    nvAlbum.create();
                    break;
                }
                case 3:
                    Livre nvOeuvre = new Livre(finalTitre, finalDate, finalFinished, finalPersonality, finalgenre, finalOrigin, finalversion, finalSupport, finalCat);
                    nvOeuvre.create();
                    System.out.println(nvOeuvre);
                    break;
                case 4:
                    JeuVideo nvJeu = new JeuVideo(finalTitre, finalDate, finalFinished, finalPersonality, finalgenre, finalOrigin, finalversion, finalSupport, finalCat, finalConsole);
                    nvJeu.create();
                    break;
            }
        }

        LocalDate stringToLocaldate(String date) {
            int y = Integer.valueOf(date.substring(0, 4));
            int m = Integer.valueOf(date.substring(5, 7));
            int d = Integer.valueOf(date.substring(8, 10));
            return LocalDate.of(y, m, d);
        }
    }

}


