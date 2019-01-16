package database;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livre extends Oeuvre {
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
    public Livre(String title, LocalDate date_oeuvre, boolean finished, Personality personality, Genre genres, Origine origine, Version versions, Support support, Categorie categorie) {
        super(title, date_oeuvre, finished, personality, genres, origine, versions, support, categorie);
    }

    private Livre(int id_oeuvre, String title, LocalDate date_ajout, LocalDate date_oeuvre, boolean finished) {
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

    public static List<Livre> read() {
        try {
            String query = "SELECT * from oeuvre inner join categorie c on oeuvre.id_c = c.id_c WHERE name_c = 'Livre' ORDER BY id DESC";
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery(query);
            ArrayList<Livre> livresTemp = new ArrayList<>();
            while (result.next()) {
                livresTemp.add(new Livre(result.getInt("id"), result.getString("title"), result.getDate("date_ajout").toLocalDate(), result.getDate("date_oeuvre").toLocalDate(), result.getBoolean("finished")));
            }
            for (Livre livre : livresTemp) {

                ResultSet resultLivreUnique = state.executeQuery("SELECT id_p, id_o, id_c, id_s, id_v, id_g from oeuvre where id = " + livre.getId_oeuvre() + " ORDER BY id DESC ");
                resultLivreUnique.next();
                livre.setPersonality(Personality.read(resultLivreUnique.getInt("id_p")));

                livre.setOrigine(Origine.read(resultLivreUnique.getInt("id_o")));

                livre.setVersion(Version.read(resultLivreUnique.getInt("id_v")));

                livre.setSupport(Support.read(resultLivreUnique.getInt("id_s")));

                livre.setGenre(Genre.read(resultLivreUnique.getInt("id_g")));
            }

            return livresTemp;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de l'oeuvre",
                "Erreur", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }
}
