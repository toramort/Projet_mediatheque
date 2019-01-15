package GUI;

import GUI.assets.CustomButton;
import resources.images.GetIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Fenetre extends JFrame {

    private String[] listContent = {"oeuvre+", "album", "game", "film", "livre"};

    public Fenetre() {
        this.setTitle("Outil de gestion de médiathèque");
        this.setSize(1920, 1080);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        ImageIcon icon = (ImageIcon) GetIcon.icones.icon_window.image();
        this.setIconImage(icon.getImage());
//
//Container qui fait toute la dimension (container) du JFrame(pour pouvoir les moduler)
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
//
//Container de gauche (containerMenu) dans lequel il y a les boutons pour séléctionner la catégorie voulu
        JPanel containerMenu = new JPanel();
        containerMenu.setLayout(new GridBagLayout());
        containerMenu.setBackground(new Color(0x858efc));
        containerMenu.setBorder(BorderFactory.createLineBorder(Color.black, 3));
//
//Création du menu & positionnement
        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(5, 1, 0, 20));
        menu.setBackground(new Color(0x858efc));
//
//
        JPanel containerRight = new JPanel();
        CardLayout mainLayout = new CardLayout();
//
//Button pour séléctionner la catégorie à afficher dans 'menu'

        JButton butAddOeuvre = CustomButton.flatButtonWhiteBlackButton("Oeuvre+");
        butAddOeuvre.setFont(new Font("Staatliches", Font.PLAIN, 20));
        butAddOeuvre.setForeground(new Color(0x3EAA40));
        butAddOeuvre.addActionListener(e -> mainLayout.show(containerRight, listContent[0]));
        menu.add(butAddOeuvre);

        JButton butMusique = CustomButton.flatButtonWhiteBlackButton("Musiques");
        butMusique.setFont(new Font("Staatliches", Font.PLAIN, 20));
        butMusique.addActionListener(e -> mainLayout.show(containerRight, listContent[1]));
        menu.add(butMusique);

        JButton butLivre = CustomButton.flatButtonWhiteBlackButton("Livres");
        butLivre.setFont(new Font("Staatliches", Font.PLAIN, 20));

        butLivre.addActionListener(e -> mainLayout.show(containerRight, listContent[2]));
        menu.add(butLivre);

        JButton butFilm = CustomButton.flatButtonWhiteBlackButton("Films");
        butFilm.setFont(new Font("Staatliches", Font.PLAIN, 20));

        butFilm.addActionListener(e -> mainLayout.show(containerRight, listContent[3]));
        menu.add(butFilm);

        JButton butJeu = CustomButton.flatButtonWhiteBlackButton("Jeux");
        butJeu.setFont(new Font("Staatliches", Font.PLAIN, 20));

        butJeu.addActionListener(e -> mainLayout.show(containerRight, listContent[4]));
        menu.add(butJeu);

//
//On créer 4 JPanel (1 pour chaque catégorie)

        JPanel addOeuvre = new AjoutOeuvrePanel();

        JPanel musique = new AffOeuvrePanel();
        musique.setBackground(Color.RED);
        //JButton butAjoutMusique = new JButton("Ajouter");
        //JButton butModMusique = new JButton("Modofier");
        //JButton butSuppMusique = new JButton("Supprimer");

        JPanel livre = new JPanel();
        livre.setBackground(Color.GREEN);

        JPanel film = new JPanel();
        film.setBackground(Color.PINK);

        JPanel jeu = new JPanel();
        jeu.setBackground(Color.BLUE);

//
        container.add(containerRight, BorderLayout.CENTER);
        containerRight.setLayout(mainLayout);

        containerRight.add(addOeuvre, listContent[0]);
        containerRight.add(musique, listContent[1]);
        containerRight.add(livre, listContent[2]);
        containerRight.add(film, listContent[3]);
        containerRight.add(jeu, listContent[4]);

//
//Enbrication des JPanel
        this.add(container);
        container.add(containerMenu, BorderLayout.LINE_START);
        containerMenu.add(menu);

        //Confirmation fermeture
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(null,
                    "Voulez-vous quitter l'application ?", "Fermeture",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        this.setVisible(true);

    }
}
