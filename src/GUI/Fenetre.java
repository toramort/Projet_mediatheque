package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Fenetre extends JFrame {

    Fenetre() {
        this.setTitle("Outil de gestion de médiathèque");
        this.setSize(1080, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        this.setVisible(true);
    }

    public class boutonMusicListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ZDialog zd = new ZDialog(null, "Coucou les ZérOs", true);
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
