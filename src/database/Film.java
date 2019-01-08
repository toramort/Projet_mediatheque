package database;

import java.util.Date;
import java.util.List;

public class Film extends Oeuvre {

    public Film(int id_oeuvre, String title, Date date_ajout, Date date_oeuvre, boolean finished, List<Personality> personalities, List<Genre> genres, Origine origine, List<Version> versions, Support support, Categorie categorie) {
        super(id_oeuvre, title, date_ajout, date_oeuvre, finished, personalities, genres, origine, versions, support, categorie);
    }

    public Film(int id_oeuvre, String title, Date date_ajout, Date date_oeuvre, boolean finished, List<Personality> personalities, List<Genre> genres, Origine origine, List<Version> versions, Support support, List<Evaluation> evaluations, Categorie categorie) {
        super(id_oeuvre, title, date_ajout, date_oeuvre, finished, personalities, genres, origine, versions, support, evaluations, categorie);
    }

    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
