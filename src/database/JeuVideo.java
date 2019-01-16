package database;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    private JeuVideo(int id_oeuvre, String title, LocalDate date_ajout, LocalDate date_oeuvre, boolean finished) {
        super(id_oeuvre, title, date_ajout, date_oeuvre, finished);
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT id_c From categorie where name_c = 'Jeu-vidéo'");
            result.next();
            this.categorie = new Categorie(result.getInt("id_c"), "Jeu-vidéo");
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public static List<JeuVideo> read() {
        try {
            String query = "SELECT * from oeuvre inner join categorie c on oeuvre.id_c = c.id_c WHERE name_c = 'Jeu-vidéo' ORDER BY id DESC";
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery(query);
            ArrayList<JeuVideo> gamesTemp = new ArrayList<>();
            while (result.next()) {
                gamesTemp.add(new JeuVideo(result.getInt("id"), result.getString("title"), result.getDate("date_ajout").toLocalDate(), result.getDate("date_oeuvre").toLocalDate(), result.getBoolean("finished")));
            }
            for (JeuVideo jeu : gamesTemp) {

                ResultSet resulGameUnique = state.executeQuery("SELECT id_p, id_o, id_c, id_s, id_v, id_g from oeuvre where id = " + jeu.getId_oeuvre() + " ORDER BY id DESC ");
                resulGameUnique.next();
                ResultSet resultConsole = state.executeQuery("SELECT id_c from console inner join console_oeuvre co on console.id_c = co.id_c inner join oeuvre o on co.id = " + jeu.getId_oeuvre());
                jeu.setPersonality(Personality.read(resulGameUnique.getInt("id_p")));

                jeu.setOrigine(Origine.read(resulGameUnique.getInt("id_o")));

                jeu.setVersion(Version.read(resulGameUnique.getInt("id_v")));

                jeu.setSupport(Support.read(resulGameUnique.getInt("id_s")));

                jeu.setGenre(Genre.read(resulGameUnique.getInt("id_g")));

                jeu.setConsole(Console.read(resultConsole.getInt("id_c")));
            }

            return gamesTemp;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de l'oeuvre",
                "Erreur", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
