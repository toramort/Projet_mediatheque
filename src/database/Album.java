package database;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class Album extends Oeuvre {
    /**
     * CONSTRUCTEUR SANS VERSION ET SANS EVALUATION
     * POUR ALBUM
     *
     * @param id_oeuvre
     * @param title
     * @param date_ajout
     * @param date_oeuvre
     * @param finished
     * @param personality
     * @param genres
     * @param origine
     * @param support
     * @param categorie
     */
    public Album(int id_oeuvre, String title, LocalDate date_ajout, LocalDate date_oeuvre, boolean finished, Personality personality, Genre genres, Origine origine, Support support, Categorie categorie) {
        super(id_oeuvre, title, date_ajout, date_oeuvre, finished, personality, genres, origine, support, categorie);
    }

    @Override
    public void create() {
        try {
            String query = "INSERT INTO oeuvre(id, title, date_ajout, date_oeuvre, finished, id_p, id_o, id_c, id_s) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, super.id_oeuvre);
            statement.setString(2, super.title);
            statement.setObject(3, super.date_ajout);
            statement.setObject(4, super.date_oeuvre);
            statement.setBoolean(5, super.finished);
            statement.setInt(6, super.personality.getId_personality());
            statement.setInt(7, super.origine.getId_o());
            statement.setInt(8, super.categorie.getId_c());
            statement.setInt(9, super.support.getId_s());
            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de l'oeuvre",
                "Erreur", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
