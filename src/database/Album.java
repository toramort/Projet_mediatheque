package database;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class Album extends Oeuvre {
    /**
     * CONSTRUCTEUR SANS VERSION ET SANS EVALUATION ET SANS ID
     * POUR ALBUM
     */
    public Album(String title, LocalDate date_oeuvre, boolean finished, Personality personality, Genre genres, Origine origine, Support support, Categorie categorie) {
        super(title, date_oeuvre, finished, personality, genres, origine, support, categorie);
    }

    @Override
    public void create() {
        try {
            String query = "INSERT INTO oeuvre(title, date_ajout, date_oeuvre, finished, id_p, id_o, id_c, id_s) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, super.title);
            statement.setObject(2, super.date_ajout);
            statement.setObject(3, super.date_oeuvre);
            statement.setBoolean(4, super.finished);
            statement.setInt(5, super.personality.getId_personality());
            statement.setInt(6, super.origine.getId_o());
            statement.setInt(7, super.categorie.getId_c());
            statement.setInt(8, super.support.getId_s());
            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de l'oeuvre",
                "Erreur", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
