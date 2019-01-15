package database;


import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public abstract class Oeuvre implements DatabaseObject {

    int id_oeuvre;


    String title;


    LocalDate date_ajout;


    LocalDate date_oeuvre;


    boolean finished;


    Personality personality;


    Genre genres;


    Origine origine;


    Version version;


    Support support;


    List<Evaluation> evaluations;


    Categorie categorie;

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
     * @param version     Version
     * @param support     Support
     * @param categorie   Categorie
     */
    Oeuvre(String title, LocalDate date_oeuvre, boolean finished, Personality personality, Genre genres, Origine origine, Version version, Support support, Categorie categorie) {
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
        this.version = version;
        this.support = support;
        this.categorie = categorie;
    }


    /**
     * CONSTRUCTEUR SANS VERSION ET SANS EVALUATION ET SANS ID
     * POUR ALBUM
     */
    Oeuvre(String title, LocalDate date_oeuvre, boolean finished, Personality personality, Genre genres, Origine origine, Support support, Categorie categorie) {
        this.title = title;
        this.date_oeuvre = date_oeuvre;
        this.date_ajout = LocalDate.now();
        this.finished = finished;
        this.personality = personality;
        this.genres = genres;
        this.origine = origine;
        this.support = support;
        this.categorie = categorie;
    }

    /*
     *CONSTRUCTOR FOR READING
     */
    Oeuvre(int id_oeuvre, String title, LocalDate date_ajout, LocalDate date_oeuvre, boolean finished) {
        this.id_oeuvre = id_oeuvre;
        this.title = title;
        this.date_ajout = date_ajout;
        this.date_oeuvre = date_oeuvre;
        this.finished = finished;
    }


    /*
    public static List<Oeuvre> read(){
        List<Oeuvre> temp = null;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * from oeuvre");
            temp = new ArrayList<>();
            while (result.next()) {
                temp.add(new Oeu(result.getInt("id_o"), result.getString("name_o")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
    */

    @Override
    public void create() {
        try {
            String query = "INSERT INTO oeuvre(id, title, date_ajout, date_oeuvre, finished, id_p, id_g, id_o, id_v, id_c, id_s) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, this.id_oeuvre);
            statement.setString(2, title);
            statement.setObject(3, date_ajout);
            statement.setObject(4, date_oeuvre);
            statement.setBoolean(5, finished);
            statement.setInt(6, personality.getId_personality());
            statement.setInt(7, genres.getId_g());
            statement.setInt(8, origine.getId_o());
            statement.setInt(9, version.getId_v());
            statement.setInt(10, categorie.getId_c());
            statement.setInt(11, support.getId_s());
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

    int getId_oeuvre() {
        return id_oeuvre;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate_ajout() {
        return date_ajout;
    }

    public LocalDate getDate_oeuvre() {
        return date_oeuvre;
    }

    public boolean isFinished() {
        return finished;
    }

    public Personality getPersonality() {
        return personality;
    }

    public Genre getGenres() {
        return genres;
    }

    public Origine getOrigine() {
        return origine;
    }

    public Version getVersion() {
        return version;
    }

    public Support getSupport() {
        return support;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setId_oeuvre(int id_oeuvre) {
        this.id_oeuvre = id_oeuvre;
    }

    void setPersonality(Personality personality) {
        this.personality = personality;
    }

    void setGenres(Genre genres) {
        this.genres = genres;
    }

    void setOrigine(Origine origine) {
        this.origine = origine;
    }

    void setVersion(Version version) {
        this.version = version;
    }

    void setSupport(Support support) {
        this.support = support;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }
}
