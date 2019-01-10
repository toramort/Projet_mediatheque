package database;

import java.time.LocalDate;

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
}
