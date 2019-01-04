package GUI;

import javax.swing.*;
import java.awt.*;


public class ZDialog extends JDialog {

    private boolean sendData;

    public ZDialog(JFrame parent, String title, boolean modal) {

        super(parent, title, modal);
        this.setSize(1080, 720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.initComponent();
    }

    private void initComponent() {
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        GridLayout mainLayout = new GridLayout(4, 2, 200, 200);
        JPanel main = new JPanel();
        main.setLayout(mainLayout);

        JLabel titre = new JLabel("Choix de la catégorie");
        container.add(titre, BorderLayout.NORTH);

        JLabel titreLabel = new JLabel("Titre : ", JLabel.TRAILING);
        main.add(titreLabel);
        JTextField titreField = new JTextField();
        titreLabel.setLabelFor(titreField);
        main.add(titreField);

        JLabel personalitiesLabel = new JLabel("Auteurs : ");
        main.add(personalitiesLabel);
        JButton personalitiesField = new JButton();
        personalitiesLabel.setLabelFor(personalitiesField);
        main.add(personalitiesField);

        JLabel dateLabel = new JLabel("Date : ");
        main.add(dateLabel);
        JTextField dateField = new JTextField();
        dateLabel.setLabelFor(dateField);
        main.add(dateField);

        JLabel genreLabel = new JLabel("Genre : ");
        main.add(genreLabel);
        JTextField genreField = new JTextField();
        genreLabel.setLabelFor(genreField);
        main.add(genreField);

        

        JButton boutonOk = new JButton();

        container.add(main, BorderLayout.CENTER);
        container.add(boutonOk, BorderLayout.SOUTH);
        this.setContentPane(container);
    }

    void showZDialog() {
        this.setVisible(true);
    }
}
