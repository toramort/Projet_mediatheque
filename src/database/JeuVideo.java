package database;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class JeuVideo extends Oeuvre {

    private Console console;

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
    public JeuVideo(String title, LocalDate date_oeuvre, boolean finished, Personality personality, Genre genres, Origine origine, Version versions, Support support, Categorie categorie, Console console) {
        super(title, date_oeuvre, finished, personality, genres, origine, versions, support, categorie);
        this.console = console;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    @Override
    public void create() {
        try {
            super.create();
            String query = "INSERT INTO console_oeuvre(id_c, id) values (?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, this.console.getId_c());
            statement.setInt(2, this.id_oeuvre);
            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de l'association console-oeuvre",
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
