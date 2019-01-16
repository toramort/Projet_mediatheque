package GUI;

import database.JeuVideo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

class GameDIsplay extends AbstractPanel {

    GameDIsplay() {
        super("Affichage des jeux");
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Titre");
        model.addColumn("Genre");
        model.addColumn("Auteur");
        model.addColumn("Date");
        model.addColumn("Date d'entrée");
        model.addColumn("Version");
        model.addColumn("Support");
        model.addColumn("Origine");
        model.addColumn("Console");

        for (JeuVideo film : JeuVideo.read()) {
            model.addRow(new Object[]{film.getTitle(), film.getGenre(), film.getPersonality(), film.getDate_oeuvre(), film.getDate_ajout(), film.getVersion(), film.getSupport(), film.getOrigine(), film.getConsole()});
        }
        JTable tableau = new JTable(model);
        tableau.setPreferredSize(new Dimension(700, 700));
        TableColumn column = null;
        for (int i = 0; i < 3; i++) {
            column = tableau.getColumnModel().getColumn(i);
            column.setPreferredWidth(30);
        }
        JScrollPane tabPane = new JScrollPane(tableau);
        tabPane.setFont(new Font("Staatliches", Font.PLAIN, 10));
        tabPane.setBounds(350, 200, 400, 400);
        this.add(tabPane);
    }

}


