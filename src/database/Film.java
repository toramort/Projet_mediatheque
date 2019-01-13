package database;

import java.time.LocalDate;

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

    public Film(int id_oeuvre, String title, LocalDate date_ajout, LocalDate date_oeuvre, boolean finished) {
        super(id_oeuvre, title, date_ajout, date_oeuvre, finished);
    }
/*
    public static List<Film> read() {
        try {
            String query = "SELECT * from oeuvre inner join categorie c on oeuvre.id_c = c.id_c WHERE name_c = 'Film'";
            Statement state  = conn.createStatement();
            ResultSet result = state.executeQuery(query);
            ArrayList<Film> oeuvresTemp = new ArrayList<>();
            while(result.next()){
                oeuvresTemp.add(new Film(result.getInt("id"), result.getString("title"), result.getDate("date_ajout").toLocalDate(), result.getDate("date_oeuvre").toLocalDate(), result.getBoolean("finished")));
                System.out.println(oeuvresTemp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de l'oeuvre",
                "Erreur", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    */
}
