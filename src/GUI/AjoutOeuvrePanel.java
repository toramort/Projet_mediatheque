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
    private JComboBox<Personality> comboPersonalities = new JComboBox<>();
    private JFormattedTextField dateField;
    private JComboBox<Console> comboConsoles = new JComboBox<>();
    private JCheckBox finished;
    private JLabel consoleLabel;
    private JLabel finishedLabel;
    private JLabel titreLabel;
    private JLabel originLabel;
    private JButton origin;
    private JLabel supportLabel;
    private JButton support;
    private JLabel versionLabel;
    private JButton version;
    private JLabel genreLabel;
    private JLabel personalitiesLabel;
    private JLabel dateLabel;
    private JButton genre;
    private JButton personalities;
    private JButton console;
    private JButton boutonEnvoyer;
    private JLabel title = new JLabel("Ajouter une oeuvre");
    private JLabel categorieLabel = new JLabel("Catégorie");



    AjoutOeuvrePanel() {





        //===== titre =====


        titreLabel = new JLabel("Titre : ");
        this.add(titreLabel);

        titre = new JTextField();
        titre.setPreferredSize(new Dimension(200, 30));
        titreLabel.setLabelFor(titre);
        this.add(titre);

        //==== catégorie =====

        for (Categorie cat : Categorie.read()) {
            comboCategorie.addItem(cat);
        }

        comboCategorie.addActionListener(e -> {
            if (comboCategorie.getSelectedItem().toString().equals("Jeu-vidéo")) {
                this.add(console);
                this.add(consoleLabel);
                this.add(comboConsoles);
            } else {
                this.remove(console);
                this.remove(consoleLabel);
                this.remove(comboConsoles);
            }

            if (comboCategorie.getSelectedItem().toString().equals("Album")) {
                this.add(version);
                this.add(versionLabel);
                this.add(comboVersions);
            } else {
                this.remove(version);
                this.remove(versionLabel);
                this.remove(comboVersions);
            }
            this.revalidate();
            this.repaint();
        });


        this.add(comboCategorie);

        //===== origine =====

        originLabel = new JLabel("Origine : ");

        origin = new JButton("Origine+");

        origin.addActionListener(e -> {
            String newNameOrigin = ConfirmNewValue.showDialogSimpleTextField();
            if (!newNameOrigin.equals("")) {
                Origine nvOrigine = new Origine(newNameOrigin);
                nvOrigine.create();
                comboOrigins.addItem(nvOrigine);
                this.setBackground(null);
            }
        });

        List<Origine> reqOri = Origine.read();
        for (Origine ori : reqOri) {
            comboOrigins.addItem(ori);
        }

        originLabel.setLabelFor(origin);
        this.add(originLabel);

        if (comboOrigins.getItemCount() == 0) {
            this.setBackground(Color.red);
        }
        this.add(comboOrigins);
        this.add(origin);

        //===== support =====


        supportLabel = new JLabel("Support : ");

        support = new JButton("Support+");
        support.setPreferredSize(new Dimension(100, 30));
        support.addActionListener(e -> {
            String newNameSupport = ConfirmNewValue.showDialogSimpleTextField();
            if (!newNameSupport.equals("")) {
                Support nvSupport = new Support(newNameSupport);
                nvSupport.create();
                comboSupports.addItem(nvSupport);
                supportLabel.setBackground(null);
            }
        });

        supportLabel.setLabelFor(support);
        this.add(supportLabel);

        List<Support> reqSupp = Support.read();
        for (Support supp : reqSupp) {
            comboSupports.addItem(supp);
        }
        if (comboSupports.getItemCount() == 0) {
            supportLabel.setBackground(Color.red);
        }
        this.add(comboSupports);
        this.add(support);

        //===== version =====
        versionLabel = new JLabel("Version : ");

        version = new JButton("Version+");
        version.setPreferredSize(new Dimension(100, 30));
        versionLabel.setLabelFor(version);
        this.add(versionLabel);

        List<Version> reqVer = Version.read();
        for (Version vers : reqVer) {
            comboVersions.addItem(vers);
        }

        if (comboVersions.getItemCount() == 0) {
            this.setBackground(Color.red);
        }

        version.addActionListener(e -> {
            String newNameVersion = ConfirmNewValue.showDialogSimpleTextField();
            if (!newNameVersion.equals("")) {
                Version nvVersion = new Version(newNameVersion);
                nvVersion.create();
                comboVersions.addItem(nvVersion);
                this.setBackground(null);
            }
        });
        this.add(comboVersions);
        this.add(version);

        //===== genre =====
        JPanel genrePanel;
        genrePanel = new JPanel(new GridLayout(1, 3, 75, 0));


        genreLabel = new JLabel("Genre : ");


        genre = new JButton("Genre+");

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
        this.add(genreLabel);
        this.add(comboGenre);
        this.add(genre);

        // ===== personalitites =====

        personalitiesLabel = new JLabel("Auteurs : ");


        personalities = new JButton("Auteurs");

        List<Personality> reqPers = Personality.read();
        for (Personality pers : reqPers) {
            comboPersonalities.addItem(pers);
        }

        if (comboPersonalities.getItemCount() == 0) {
            this.setBackground(Color.red);
        }

        personalities.addActionListener(e -> {
            List newParamPersonality = ConfirmNewValue.showDialogTripleField();
            if (!newParamPersonality.equals(new ArrayList<>())) {
                Personality nvPersonality = new Personality((String) newParamPersonality.get(0), (String) newParamPersonality.get(1), (String) newParamPersonality.get(2), (Job) newParamPersonality.get(3));
                nvPersonality.create();
                nvPersonality.createAssocJob();
                comboPersonalities.addItem(nvPersonality);
                this.setBackground(null);
            }
        });
        personalitiesLabel.setLabelFor(personalities);
        this.add(personalitiesLabel);
        this.add(comboPersonalities);
        this.add(personalities);

        //===== date =====

        dateLabel = new JLabel("Date : ");
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

        this.add(dateLabel);
        this.add(dateField);


        //===== console =====

        consoleLabel = new JLabel("Console : ");

        console = new JButton("Console+");
        List<Console> reqCons = Console.read();
        for (Console cons : reqCons) {
            comboConsoles.addItem(cons);
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
        this.add(consoleLabel);
        this.add(comboConsoles);
        this.add(console);


        //===== finished =====


        finishedLabel = new JLabel("Terminé : ");
        finished = new JCheckBox();
        finishedLabel.setLabelFor(finished);
        this.add(finishedLabel);
        this.add(finished);


        boutonEnvoyer = new JButton("Envoyer");
        boutonEnvoyer.addActionListener(new FinalListener());
        this.add(boutonEnvoyer);

        

        this.setLayout(null);
        title.setFont(new Font("Staatliches", Font.PLAIN, 40));
        title.setBounds(550, 10, 400, 50);
        this.add(title);

        categorieLabel.setBounds(450, 150, 100, 35);
        categorieLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
        this.add(categorieLabel);

        comboCategorie.setBounds(600, 150, 100, 35);

        titreLabel.setBounds(450, 200, 100, 35);
        titreLabel.setFont (new Font("Staatliches", Font.PLAIN, 20));
        titre.setBounds(600, 200, 200, 35);

        personalitiesLabel.setBounds(450,250,100,35);
        personalitiesLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
        comboPersonalities.setBounds(600, 250, 200, 35);
        personalities.setBounds(810, 250, 200, 35);

        genreLabel.setBounds(450, 300, 100, 35);
        genreLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
        comboGenre.setBounds(600,300,200,35);
        genre.setBounds(810,300,200,35);

        supportLabel.setBounds(450,350,100,35);
        supportLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
        comboSupports.setBounds(600,350,200,35);
        support.setBounds(810,350,200,35);

        versionLabel.setBounds(450,400,100,35);
        versionLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
        comboVersions.setBounds(600,400,200,35);
        version.setBounds(810,400,200,35);

        originLabel.setBounds(450,450,100,35);
        originLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
        comboOrigins.setBounds(600,450,200,35);
        origin.setBounds(810,450,200,35);

        dateLabel.setBounds(450,500,100,35);
        dateLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
        dateField.setBounds(600,500,200,35);

        finishedLabel.setBounds(450,550,100,35);
        finishedLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
        finished.setBounds(790,560,20,20);



        this.setBackground(Color.white);

    }


    LocalDate stringToLocaldate(String date) {
        int y = Integer.valueOf(date.substring(0, 4));
        int m = Integer.valueOf(date.substring(5, 7));
        int d = Integer.valueOf(date.substring(8, 10));
        return LocalDate.of(y, m, d);
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
            if (AjoutOeuvrePanel.this.consoleLabel.isVisible()) {
                finalConsole = (Console) comboConsoles.getSelectedItem();
            }
            try {
                finalDate = stringToLocaldate(dateField.getText());
            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(null, "Remplissez bien la date !",
                    "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Date erronée", "Error", JOptionPane.ERROR_MESSAGE);
            }
            boolean finalFinished = finished.isSelected();
            String message = "Vouslez-vous créer l'oeuvre suivante avec ces paramètres ? " +
                "\nTitre : " + finalTitre +
                "\nCatégorie : " + finalCat +
                "\nOrigine : " + finalOrigin +
                "\nSupport : " + finalSupport +
                "\nGenre : " + finalgenre +
                "\nPersonne : " + finalPersonality +
                "\nDate : " + finalDate;


            switch (finalCat.getId_c()) {
                case 1: {
                    message += "\nVersion : " + finalversion;
                    if (JOptionPane.showConfirmDialog(null, message, "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        Film nvOeuvre = new Film(finalTitre, finalDate, finalFinished, finalPersonality, finalgenre, finalOrigin, finalversion, finalSupport, finalCat);
                        nvOeuvre.create();
                        System.out.println(finalCat.getName_c());
                    }
                    break;
                }
                case 2: {
                    if (JOptionPane.showConfirmDialog(null, message, "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        Album nvAlbum = new Album(finalTitre, finalDate, finalFinished, finalPersonality, finalgenre, finalOrigin, finalSupport, finalCat);
                        nvAlbum.create();
                    }
                    break;

                }
                case 3:
                    message += "\nVersion : " + finalversion;
                    if (JOptionPane.showConfirmDialog(null, message, "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                        Livre nvOeuvre = new Livre(finalTitre, finalDate, finalFinished, finalPersonality, finalgenre, finalOrigin, finalversion, finalSupport, finalCat);
                        nvOeuvre.create();
                    }
                    break;
                case 4:
                    message += "\nVersion : " + finalversion + "\nConsole : " + finalConsole;
                    if (JOptionPane.showConfirmDialog(null, message, "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        JeuVideo nvJeu = new JeuVideo(finalTitre, finalDate, finalFinished, finalPersonality, finalgenre, finalOrigin, finalversion, finalSupport, finalCat, finalConsole);
                        nvJeu.create();
                    }
                    break;
            }
        }
    }
}


