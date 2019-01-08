package GUI;


import database.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
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
    private JComboBox<Genre> comboGenre = new JComboBox<>();
    private JButton genre;
    private JPanel morceauxPanel;
    private JPanel personalitiesPanel;
    private JComboBox<Personality> comboPersonalities = new JComboBox<>();
    private JButton personalities;
    private JPanel jobsPanel;
    private JComboBox<Job> comboJobs = new JComboBox<>();
    private JButton job;
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
        comboCategorie.addActionListener(e -> {
            if (comboCategorie.getSelectedItem().toString().equals("Jeu-vidéo")) {
                this.add(consolePanel);
            } else {
                this.remove(consolePanel);
            }

            if (comboCategorie.getSelectedItem().toString().equals("Album")) {
                this.add(morceauxPanel);
            } else {
                this.remove(morceauxPanel);
            }
            this.revalidate();
            this.repaint();
        });

        categoriePanel.setBorder(BorderFactory.createTitledBorder("Categorie"));
        categorieLabel.setLabelFor(comboCategorie);
        categoriePanel.add(comboCategorie);
        this.add(categoriePanel);

        //===== origine =====
        JPanel originPanel = new JPanel(new GridLayout(1, 3));

        JLabel originLabel = new JLabel("Origine : ");

        origin = new JButton("Origin+");
        origin.setPreferredSize(new Dimension(100, 30));
        origin.addActionListener(e -> {
            String newNameOrigin = ConfirmNewValue.showDialogSimpleTextField();
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
            String newNameSupport = ConfirmNewValue.showDialogSimpleTextField();
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
        this.add(versionPanel);

        //===== genre =====
        JPanel genrePanel = new JPanel(new GridLayout(1, 3));

        JLabel genreLabel = new JLabel("Genre : ");

        JButton genre = new JButton("Genre+");

        List<Genre> reqGenre = Master.readGenres();
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
                comboGenre.setBackground(null);
            }
        });
        genreLabel.setLabelFor(genre);
        genrePanel.add(genreLabel);
        genrePanel.add(comboGenre);
        genrePanel.add(genre);
        this.add(genrePanel);



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


        // ===== personalitites =====

        personalitiesPanel = new JPanel(new GridLayout(1, 2));

        JLabel personalitiesLabel = new JLabel("Auteurs : ");

        personalities = new JButton("Auteurs");

        List<Personality> reqPers = Master.readPersonality();
        for (Personality pers : reqPers) {
            comboPersonalities.addItem(pers);
        }

        if (comboPersonalities.getItemCount() == 0) {
            personalitiesPanel.setBackground(Color.red);
        }

        personalities.addActionListener(e -> {
            List<String> newParamPersonality = ConfirmNewValue.showDialogTripleField();
            if (!newParamPersonality.equals(new ArrayList<>())) {
                Personality nvPersonality = new Personality(newParamPersonality.get(0), newParamPersonality.get(1), newParamPersonality.get(2));
                nvPersonality.create();
                comboPersonalities.addItem(nvPersonality);
                personalitiesPanel.setBackground(null);
            }
        });
        personalitiesLabel.setLabelFor(personalities);
        personalitiesPanel.add(personalitiesLabel);
        personalitiesPanel.add(comboPersonalities);
        personalitiesPanel.add(personalities);
        this.add(personalitiesPanel);


        //===== jobs =====
        jobsPanel = new JPanel(new GridLayout(1, 3));
        JLabel jobsLabel = new JLabel("Rôle : ");
        job = new JButton("Rôle+");

        List<Job> reqJobs = Master.readJobs();
        for (Job job1 : reqJobs) {
            comboJobs.addItem(job1);
        }

        if (comboJobs.getItemCount() == 0) {
            jobsPanel.setBackground(Color.red);
        }

        job.addActionListener(e -> {
            String newNameJob = ConfirmNewValue.showDialogSimpleTextField();
            if (!newNameJob.equals("")) {
                Job nvJob = new Job(newNameJob);
                nvJob.create();
                comboJobs.addItem(nvJob);
                jobsPanel.setBackground(null);
            }
        });

        jobsPanel.add(jobsLabel);
        jobsPanel.add(comboJobs);
        jobsPanel.add(job);
        this.add(jobsPanel);

        //===== console =====
        consolePanel = new JPanel(new GridLayout(1, 3));

        JLabel consoleLabel = new JLabel("Console : ");

        JButton console = new JButton("Console+");
        List<Console> reqCons = Master.readConsole();
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

        finishedPanel = new JPanel(new GridLayout(1, 2));
        finishedLabel = new JLabel("Terminé : ");
        finished = new JCheckBox();
        finishedLabel.setLabelFor(finished);
        finishedPanel.add(finishedLabel);
        finishedPanel.add(finished);
        this.add(finishedPanel);


        JButton boutonEnvoyer = new JButton("Envoyer");
        boutonEnvoyer.addActionListener(new FinalListener());
        this.add(boutonEnvoyer);

    }


    class FinalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String finalTitre = titre.getText();
            Categorie finalCat = (Categorie) comboCategorie.getSelectedItem();
            Origine finalOrigin = (Origine) comboOrigins.getSelectedItem();
            Support finalSupport = (Support) comboSupports.getSelectedItem();
            Version finalversion = (Version) comboVersions.getSelectedItem();
            Genre finalgenre = (Genre) comboGenre.getSelectedItem();
            Personality finalPersonality = (Personality) comboPersonalities.getSelectedItem();
            Job finalJob = (Job) comboJobs.getSelectedItem();
            String finalFinished = String.valueOf(finished.isSelected());

        }
    }

}
