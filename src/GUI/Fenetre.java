package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

class Fenetre extends JFrame {

    Fenetre() {
        this.setTitle("Outil de gestion de médiathèque");
        this.setSize(1080, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JPanel container = new JPanel();

        JPanel main = new JPanel();
        main.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(50, 20, 20, 20);

        JLabel titre = new JLabel("Choix de la catégorie");
        main.add(titre, gbc);


        JButton boutonMusique = new JButton("Album");
        main.add(boutonMusique, gbc);
        JButton boutonFilm = new JButton("Film");
        main.add(boutonFilm, gbc);
        JButton boutonLivre = new JButton("Livre");
        main.add(boutonLivre, gbc);
        JButton boutonGame = new JButton("Jeu");
        main.add(boutonGame, gbc);

        container.add(main, BorderLayout.CENTER);

        boutonMusique.addActionListener(new boutonMusicListener());
        boutonFilm.addActionListener(new boutonFilmListener());
        boutonLivre.addActionListener(new boutonFilmListener());
        boutonGame.addActionListener(new boutonGameListener());

        this.setContentPane(container);

        //Confirmation fermeture
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing (WindowEvent windowEvent){
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

    public class boutonMusicListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ZDialog zd = new ZDialog(null, "Album", true);
            zd.showZDialog();
        }
    }


    public class boutonFilmListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane messageGame = new JOptionPane();
            JOptionPane.showMessageDialog(null, "l'utilisateur insère les infos", "information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public class boutonLivreListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane messageGame = new JOptionPane();
            JOptionPane.showMessageDialog(null, "l'utilisateur insère les infos", "information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public class boutonGameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane messageGame = new JOptionPane();
            JOptionPane.showMessageDialog(null, "l'utilisateur insère les infos", "information", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
