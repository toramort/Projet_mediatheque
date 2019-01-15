package GUI;

import database.Film;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class AffOeuvrePanel extends JPanel {

    AffOeuvrePanel() {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Titre");
        model.addColumn("Genre");
        model.addColumn("Auteur");
        model.addColumn("Date");
        model.addColumn("Date d'entrée");
        model.addColumn("Version");
        model.addColumn("Support");
        model.addColumn("Origine");

        for (Film film : Film.read()) {
            model.addRow(new Object[]{film.getTitle(), film.getGenres(), film.getPersonality(), film.getDate_oeuvre(), film.getDate_ajout(), film.getVersion(), film.getSupport(), film.getOrigine()});
        }
        JTable tableau = new JTable(model);
        tableau.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        this.add(new JScrollPane(tableau));
    }
}
