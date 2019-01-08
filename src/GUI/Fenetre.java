package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

class Fenetre extends JFrame {

    private String[] listContent = {"oeuvre+", "album", "game", "film", "livre"};

    private int indice = 0;

    Fenetre() {
        this.setTitle("Outil de gestion de médiathèque");
        this.setSize(1080, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());

        JPanel containerMenu = new JPanel();
        containerMenu.setLayout(new GridBagLayout());
        containerMenu.setBackground(new Color(0xb5c5dd));
        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(5, 1));

        JPanel main = new JPanel();
        CardLayout mainLayout = new CardLayout();


        JButton addOeuvre = new FlatButton("Oeuvre +");
        addOeuvre.addActionListener(e -> mainLayout.next(main));
        menu.add(addOeuvre);

        JButton album = new FlatButton("Albums");
        album.addActionListener(e -> mainLayout.show(main, listContent[1]));
        menu.add(album);

        JButton game = new FlatButton("Music");
        game.addActionListener(e -> mainLayout.show(main, listContent[2]));
        menu.add(game);
        JButton film = new FlatButton("film");
        menu.add(film);
        JButton book = new FlatButton("Livres");
        menu.add(book);

        JPanel ajoutOeuvre = new AjoutOeuvrePanel();

        JPanel musics = new JPanel();

        JPanel games = new JPanel();

        JPanel movies = new JPanel();

        JPanel books = new JPanel();


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;

        containerMenu.add(menu);
        container.add(containerMenu, BorderLayout.LINE_START);

        main.add(ajoutOeuvre, listContent[0]);
        main.add(musics, listContent[1]);
        main.add(games, listContent[2]);
        main.add(movies, listContent[3]);
        main.add(books, listContent[4]);

        main.setLayout(mainLayout);
        container.add(main, BorderLayout.CENTER);

        this.setContentPane(container);

        //Confirmation fermeture
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
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
