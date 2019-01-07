package dataObjects;

import java.util.Date;
import java.util.List;

public class Album extends Oeuvre {

    private List<Morceau> morceaux;
    private int id_album;

    public Album(int id_oeuvre, String title, Date date_ajout, Date date_oeuvre, boolean finished, List<Personality> personalities, List<Genre> genres, Origine origine, List<Version> versions, Support support, List<Evaluation> evaluations, Console console, Categorie categorie, List<Morceau> morceaux, int id_album) {
        super(id_oeuvre, title, date_ajout, date_oeuvre, finished, personalities, genres, origine, versions, support, evaluations, console, categorie);
        this.morceaux = morceaux;
        this.id_album = id_album;
    }
}
