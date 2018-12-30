package GUI;

import javax.swing.*;
import java.awt.*;

public class ZDialog extends JDialog {

    private boolean sendData;

    public ZDialog(JFrame parent, String title, boolean modal) {

        super(parent, title, modal);
        this.setSize(550, 270);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.initComponent();
    }

    private void initComponent() {
        JPanel container = new JPanel();

        JPanel main = new JPanel();
        JLabel titre = new JLabel("Choix de la catégorie");
        main.add(titre);

        JTextField titreField = new JTextField("Album");
        main.add(titreField);
        JTextField auteurField = new JTextField("Film");
        main.add(auteurField);
        JTextField dateField = new JTextField("Livre");
        main.add(dateField);

        JButton boutonOk = new JButton();

        container.add(main, BorderLayout.CENTER);
        container.add(boutonOk, BorderLayout.SOUTH);
        this.setContentPane(container);
    }

    void showZDialog() {
        this.setVisible(true);
    }
}
