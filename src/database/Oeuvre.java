package database;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public abstract class Oeuvre implements DatabaseObject {

    private int id_oeuvre;
    private String title;
    private LocalDate date_ajout;
    private LocalDate date_oeuvre;
    private boolean finished;
    private Personality personality;
    private Genre genres;
    private Origine origine;
    private Version versions;
    private Support support;
    private List<Evaluation> evaluations;
    private Categorie categorie;


    Oeuvre() {
    }

    /**
     * CONSTRUCTEUR NOUVELLE OEUVRE
     * ID et DATE_AJOUT AUTOGENERES
     *
     * @param title       Titre de l'oeuvre
     * @param date_oeuvre Date de l'oeuvre
     * @param finished    Complétude
     * @param personality Auteur de l'oeuvre
     * @param genres      Genre
     * @param origine     Origine
     * @param versions    Version
     * @param support     Support
     * @param categorie   Categorie
     */
    Oeuvre(String title, LocalDate date_oeuvre, boolean finished, Personality personality, Genre genres, Origine origine, Version versions, Support support, Categorie categorie) {
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT MAX(id) as max_id from oeuvre ");
            result.next();
            this.id_oeuvre = result.getInt("max_id") + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.title = title;
        this.date_ajout = LocalDate.now();
        this.date_oeuvre = date_oeuvre;
        this.finished = finished;
        this.personality = personality;
        this.genres = genres;
        this.origine = origine;
        this.versions = versions;
        this.support = support;
        this.categorie = categorie;
    }


    @Override
    public void create() {
        try {
            String query = "INSERT INTO oeuvre(id, title, date_ajout, date_oeuvre, finished, id_p, id_o, id_c, id_s) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, this.id_oeuvre);
            statement.setString(2, title);
            statement.setObject(3, date_ajout);
            statement.setObject(4, date_oeuvre);
            statement.setBoolean(5, finished);
            statement.setInt(6, personality.getId_personality());
            statement.setInt(7, origine.getId_o());
            statement.setInt(8, categorie.getId_c());
            statement.setInt(9, support.getId_s());
            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de l'oeuvre",
                "Erreur", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }


    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

}
