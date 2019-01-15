package GUI;


import GUI.assets.CustomButton;
import GUI.assets.FlatCombo;
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
    int spaceLine = 55;
    private JComboBox<Categorie> comboCategorie = new FlatCombo<>();
    private JComboBox<Origine> comboOrigins = new FlatCombo<>();
    private JComboBox<Support> comboSupports = new FlatCombo<>();
    private JComboBox<Version> comboVersions = new FlatCombo<>();
    private JComboBox<Genre> comboGenre = new FlatCombo<>();
    private JFormattedTextField dateField;
    private JComboBox<Personality> comboPersonalities = new FlatCombo<>();
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
    int posX = 400;
    int posY = 120;
    int spaceXCombo = 150;
    private JComboBox<Console> comboConsoles = new FlatCombo<>();
    int spaceXButton = 210;
    int dimComboX = 200;
    int dimComboY = 35;
    int dimButtonX = 200;
    int dimButtonY = 35;
    int spaceXtitle = 200;
    int spaceYtitle = -100;
    private JPanel titrePanel = new JPanel();


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

                originLabel.setBounds(posX, posY + 7 * spaceLine, 100, 35);
                originLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
                comboOrigins.setBounds(posX + spaceXCombo, posY + 7 * spaceLine, dimComboX, dimComboY);
                origin.setBounds(posX + spaceXCombo + spaceXButton, posY + 7 * spaceLine, dimButtonX, dimButtonY);

                dateLabel.setBounds(posX, posY + 8 * spaceLine, 100, 35);
                dateLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
                dateField.setBounds(posX + spaceXCombo, posY + 8 * spaceLine, dimComboX, dimComboY);

                finishedLabel.setBounds(posX, posY + 9 * spaceLine, 100, 35);
                finishedLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
                finished.setBounds(posX + spaceXCombo + spaceXButton / 2 - 10, posY + 9 * spaceLine + 5, 20, 20);

                boutonEnvoyer.setBounds(posX + spaceXCombo + spaceXButton / 2, posY + 10 * spaceLine, dimButtonX, dimButtonY);
            } else {
                this.remove(console);
                this.remove(consoleLabel);
                this.remove(comboConsoles);

                originLabel.setBounds(posX, posY + 6 * spaceLine, 100, 35);
                originLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
                comboOrigins.setBounds(posX + spaceXCombo, posY + 6 * spaceLine, dimComboX, dimComboY);
                origin.setBounds(posX + spaceXCombo + spaceXButton, posY + 6 * spaceLine, dimButtonX, dimButtonY);

                dateLabel.setBounds(posX, posY + 7 * spaceLine, 100, 35);
                dateLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
                dateField.setBounds(posX + spaceXCombo, posY + 7 * spaceLine, dimComboX, dimComboY);

                finishedLabel.setBounds(posX, posY + 8 * spaceLine, 100, 35);
                finishedLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
                finished.setBounds(posX + spaceXCombo + spaceXButton / 2 - 10, posY + 8 * spaceLine + 5, 20, 20);

                boutonEnvoyer.setBounds(posX + spaceXCombo + spaceXButton / 2, posY + 9 * spaceLine, dimButtonX, dimButtonY);
            }

            if (comboCategorie.getSelectedItem().toString().equals("Album")) {
                this.remove(version);
                this.remove(versionLabel);
                this.remove(comboVersions);
                originLabel.setBounds(posX, posY + 5 * spaceLine, 100, 35);
                originLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
                comboOrigins.setBounds(posX + spaceXCombo, posY + 5 * spaceLine, dimComboX, dimComboY);
                origin.setBounds(posX + spaceXCombo + spaceXButton, posY + 5 * spaceLine, dimButtonX, dimButtonY);

                dateLabel.setBounds(posX, posY + 6 * spaceLine, 100, 35);
                dateLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
                dateField.setBounds(posX + spaceXCombo, posY + 6 * spaceLine, dimComboX, dimComboY);

                finishedLabel.setBounds(posX, posY + 7 * spaceLine, 100, 35);
                finishedLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
                finished.setBounds(posX + spaceXCombo + spaceXButton / 2 - 10, posY + 7 * spaceLine + 5, 20, 20);

                boutonEnvoyer.setBounds(posX + spaceXCombo + spaceXButton / 2, posY + 8 * spaceLine, dimButtonX, dimButtonY);

            } else if (!comboCategorie.getSelectedItem().toString().equals("Jeu-vidéo")) {
                this.add(version);
                this.add(versionLabel);
                this.add(comboVersions);
                originLabel.setBounds(posX, posY + 6 * spaceLine, 100, 35);
                originLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
                comboOrigins.setBounds(posX + spaceXCombo, posY + 6 * spaceLine, dimComboX, dimComboY);
                origin.setBounds(posX + spaceXCombo + spaceXButton, posY + 6 * spaceLine, dimButtonX, dimButtonY);

                dateLabel.setBounds(posX, posY + 7 * spaceLine, 100, 35);
                dateLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
                dateField.setBounds(posX + spaceXCombo, posY + 7 * spaceLine, dimComboX, dimComboY);

                finishedLabel.setBounds(posX, posY + 8 * spaceLine, 100, 35);
                finishedLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
                finished.setBounds(posX + spaceXCombo + spaceXButton / 2 - 10, posY + 8 * spaceLine + 5, 20, 20);

                boutonEnvoyer.setBounds(posX + spaceXCombo + spaceXButton / 2, posY + 9 * spaceLine, dimButtonX, dimButtonY);
            }


            this.revalidate();
            this.repaint();
        });


        this.add(comboCategorie);

        //===== origine =====

        originLabel = new JLabel("Origine : ");

        origin = CustomButton.flatButtonWhite("Origin+");

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

        support = CustomButton.buttonIconAdd();
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

        version = CustomButton.flatButtonWhite("Version+");
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


        genre = CustomButton.flatButtonWhite("Genre+");

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


        personalities = CustomButton.flatButtonWhite("Auteurs");

        List<Personality> reqPers = Personality.read();
        for (Personality pers : reqPers) {
            comboPersonalities.addItem(pers);
        }

        if (comboPersonalities.getItemCount() == 0) {
            this.setBackground(Color.red);
        }

        personalities.addActionListener(e -> {
            ConfirmNewValue box = new ConfirmNewValue();
            List newParamPersonality = box.showDialogTripleField();
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

        console = CustomButton.flatButtonWhite("Console+");
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


        //===== finished =====


        finishedLabel = new JLabel("Terminé : ");
        finished = new JCheckBox();
        finishedLabel.setLabelFor(finished);
        this.add(finishedLabel);
        this.add(finished);


        boutonEnvoyer = CustomButton.flatButtonWhite("Envoyer");
        boutonEnvoyer.addActionListener(new FinalListener());
        this.add(boutonEnvoyer);

        this.setLayout(null);
        title.setFont(new Font("Staatliches", Font.PLAIN, 40));
        title.setBounds(posX + spaceXtitle, posY + spaceYtitle, 400, 50);
        titrePanel.add(title);
        titrePanel.setBounds(0, 0, 2000, 90);
        titrePanel.setBackground(new Color(0x858efc));
        titrePanel.setLayout(null);
        this.add(titrePanel);

        categorieLabel.setBounds(posX, posY, 100, 35);
        categorieLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
        this.add(categorieLabel);
        comboCategorie.setBounds(posX + spaceXCombo, posY, dimComboX, 35);

        titreLabel.setBounds(posX, posY + spaceLine, 100, 35);
        titreLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
        titre.setBounds(posX + spaceXCombo, posY + spaceLine, dimComboX, dimComboY);

        personalitiesLabel.setBounds(posX, posY + 2 * spaceLine, 100, 35);
        personalitiesLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
        comboPersonalities.setBounds(posX + spaceXCombo, posY + 2 * spaceLine, dimComboX, dimComboY);
        personalities.setBounds(posX + spaceXCombo + spaceXButton, posY + 2 * spaceLine, dimButtonX, dimButtonY);

        genreLabel.setBounds(posX, posY + 3 * spaceLine, 100, 35);
        genreLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
        comboGenre.setBounds(posX + spaceXCombo, posY + 3 * spaceLine, dimComboX, dimComboY);
        genre.setBounds(posX + spaceXCombo + spaceXButton, posY + 3 * spaceLine, dimButtonX, dimButtonY);

        supportLabel.setBounds(posX, posY + 4 * spaceLine, 100, 35);
        supportLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
        comboSupports.setBounds(posX + spaceXCombo, posY + 4 * spaceLine, dimComboX, dimComboY);
        support.setBounds(posX + spaceXCombo + 210, posY + 4 * spaceLine, 35, 35);

        versionLabel.setBounds(posX, posY + 5 * spaceLine, 100, 35);
        versionLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
        comboVersions.setBounds(posX + spaceXCombo, posY + 5 * spaceLine, dimComboX, dimComboY);
        version.setBounds(posX + spaceXCombo + spaceXButton, posY + 5 * spaceLine, dimButtonX, dimButtonY);

        consoleLabel.setBounds(posX, posY + 6 * spaceLine, 100, 35);
        consoleLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
        comboConsoles.setBounds(posX + spaceXCombo, posY + 6 * spaceLine, dimComboX, dimComboY);
        console.setBounds(posX + spaceXCombo + spaceXButton, posY + 6 * spaceLine, dimButtonX, dimButtonY);

        originLabel.setBounds(posX, posY + 6 * spaceLine, 100, 35);
        originLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
        comboOrigins.setBounds(posX + spaceXCombo, posY + 6 * spaceLine, dimComboX, dimComboY);
        origin.setBounds(posX + spaceXCombo + spaceXButton, posY + 6 * spaceLine, dimButtonX, dimButtonY);

        dateLabel.setBounds(posX, posY + 7 * spaceLine, 100, 35);
        dateLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
        dateField.setBounds(posX + spaceXCombo, posY + 7 * spaceLine, dimComboX, dimComboY);

        finishedLabel.setBounds(posX, posY + 8 * spaceLine, 100, 35);
        finishedLabel.setFont(new Font("Staatliches", Font.PLAIN, 20));
        finished.setBounds(posX + spaceXCombo + spaceXButton / 2 - 10, posY + 8 * spaceLine + 5, 20, 20);

        boutonEnvoyer.setBounds(posX + spaceXCombo + spaceXButton / 2, posY + 9 * spaceLine, dimButtonX, dimButtonY);
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


