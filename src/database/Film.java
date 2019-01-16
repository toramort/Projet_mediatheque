package database;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Film extends Oeuvre {

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
    public Film(String title, LocalDate date_oeuvre, boolean finished, Personality personality, Genre genres, Origine origine, Version versions, Support support, Categorie categorie) {
        super(title, date_oeuvre, finished, personality, genres, origine, versions, support, categorie);
    }

    private Film(int id_oeuvre, String title, LocalDate date_ajout, LocalDate date_oeuvre, boolean finished) {
        super(id_oeuvre, title, date_ajout, date_oeuvre, finished);
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT id_c From categorie where name_c = 'Film'");
            result.next();
            this.categorie = new Categorie(result.getInt("id_c"), "Film");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Film> read() {
        try {
            String query = "SELECT * from oeuvre inner join categorie c on oeuvre.id_c = c.id_c WHERE name_c = 'Film' ORDER BY id DESC";
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery(query);
            ArrayList<Film> filmsTemp = new ArrayList<>();
            while (result.next()) {
                filmsTemp.add(new Film(result.getInt("id"), result.getString("title"), result.getDate("date_ajout").toLocalDate(), result.getDate("date_oeuvre").toLocalDate(), result.getBoolean("finished")));
            }
            for (Film film : filmsTemp) {

                ResultSet resultFilmUnique = state.executeQuery("SELECT id_p, id_o, id_c, id_s, id_v, id_g from oeuvre where id = " + film.getId_oeuvre() + " ORDER BY id DESC ");
                resultFilmUnique.next();
                film.setPersonality(Personality.read(resultFilmUnique.getInt("id_p")));

                film.setOrigine(Origine.read(resultFilmUnique.getInt("id_o")));

                film.setVersion(Version.read(resultFilmUnique.getInt("id_v")));

                film.setSupport(Support.read(resultFilmUnique.getInt("id_s")));

                film.setGenre(Genre.read(resultFilmUnique.getInt("id_g")));
            }

            return filmsTemp;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de l'oeuvre",
                "Erreur", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Film{" +
            "id_oeuvre=" + id_oeuvre +
            ", title='" + title + '\'' +
            ", date_ajout=" + date_ajout +
            ", date_oeuvre=" + date_oeuvre +
            ", finished=" + finished +
            ", personality=" + personality +
            ", genre=" + genre +
            ", origine=" + origine +
            ", version=" + version +
            ", support=" + support +
            ", evaluations=" + evaluations +
            ", categorie=" + categorie +
            '}';
    }
}
